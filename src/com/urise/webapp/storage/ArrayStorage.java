package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int storageLength = 10000;
    private Resume[] storage = new Resume[storageLength];
    private int size; // полезный размер массива


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = findResumeIndex(r.getUuid());
        if ( index >= 0) {
            System.out.println("SAVE ERROR: Resume already exists");
        } else {
            if (size == storageLength) {
                System.out.println("Attention!!! storage[] is full");
            }
            storage[size] = r;
            size++;
            }
    }

    public void update(Resume r) {
        int index = findResumeIndex(r.getUuid());
        if ( index == -1) {
            System.out.println("UPDATE ERROR: Resume doesn't exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {
        int index = findResumeIndex(uuid);
        if (index == -1) {
            System.out.print("GET ERROR: Resume doesn't exist \t");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findResumeIndex(uuid);
        if ( index == -1) {
            System.out.println("DELETE ERROR: Resume doesn't exist");
            } else {
            storage[index] = storage[size-1];
            storage[size-1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findResumeIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}
