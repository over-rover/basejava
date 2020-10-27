package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected Object getKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insert(Resume r, int searchKey) {
        storage[size] = r;
    }

    @Override
    protected void remove(int searchKey) {
        storage[searchKey] = storage[size - 1];
    }


}
