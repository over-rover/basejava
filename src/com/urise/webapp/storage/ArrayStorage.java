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
        int i = findResumeIndex(r.getUuid());
        if ( i == -1) {
            storage[size] = r;
            size++;
            if (size == storageLength) {
                System.out.println("Attention!!! storage[] is full");
            }
        } else {
            System.out.println("SAVE ERROR: Resume already exists");
        }
    }

    public void update(Resume r, String uuid) {
        int i = findResumeIndex(uuid);
        if ( i == -1) {
            r.setUuid(uuid);
        } else {
            System.out.println("UPDATE ERROR: Resume already exists, choose another uuid");
        }
    }

    public Resume get(String uuid) {
        int i = findResumeIndex(uuid);
        if (i == -1) {
            System.out.print("GET ERROR: Resume doesn't exist \t");
            return null;
        } else return storage[i];
    }

    public void delete(String uuid) {
        int i = findResumeIndex(uuid);
        if ( i == -1) {
            System.out.println("DELETE ERROR: Resume doesn't exist");
            } else {
            storage[i] = storage[size-1];
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

    public int findResumeIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
