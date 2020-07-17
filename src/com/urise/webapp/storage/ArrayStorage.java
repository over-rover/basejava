package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    protected void insert(Resume r, int index) {
        storage[size] = r;
    }

    protected void remove(int index) {
        storage[index] = storage[size - 1];
    }
}
