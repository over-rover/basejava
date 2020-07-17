package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    public void saveResume(Resume r, int index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("storage[] overflow!", r.getUuid());
        }
        insert(r, index);
        size++;
    }

    public void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    public Resume getResume(int index) {
        return storage[index];
    }

    public Resume[] getAllResumes() {
        return Arrays.copyOf(storage, size);
    }

    public void deleteResume(int index) {
        remove(index);
        storage[size - 1] = null;
        size--;
    }

    public void deleteAll() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    abstract int getIndex(String uuid);

    abstract void insert(Resume r, int index);

    abstract void remove(int index);
}
