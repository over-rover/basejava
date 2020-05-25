package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = findResumeIndex(uuid);
        if (index == -1) {
            System.out.print("GET ERROR: Resume doesn't exist \t");
            return null;
        }
        return storage[index];
    }

    protected abstract int findResumeIndex(String uuid);
}
