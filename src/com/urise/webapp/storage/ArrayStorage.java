package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (findResumeIndex(r.getUuid()) >= 0) {
            System.out.println("SAVE ERROR: Resume already exists");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Error!!! storage[] overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r) {
        int index = findResumeIndex(r.getUuid());
        if (index == -1) {
            System.out.println("UPDATE ERROR: Resume doesn't exist");
        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = findResumeIndex(uuid);
        if (index == -1) {
            System.out.println("DELETE ERROR: Resume doesn't exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected int findResumeIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
            /*
             * В уроке 3 используется запись:
             * if (uuid == storage[index].getUuid())
             * То есть сверяются адреса ссылок, но не содержимое объектов. Это корректно?
             */
        }
        return -1;
    }
}
