package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected Object getKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    protected void insert(Resume r, Object searchKey) {
        storage[size] = r;
    }

    protected void remove(Object searchKey) {
        storage[(int) searchKey] = storage[size - 1];
    }
}
