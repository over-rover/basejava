package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    public void saveResume(Resume r, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("storage[] overflow!", r.getUuid());
        }
        insert(r, searchKey);
        size++;
    }

    public void updateResume(Resume r, Object searchKey) {
        storage[(int) searchKey] = r;
    }

    public Resume getResume(Object searchKey) {
        return storage[(int) searchKey];
    }

    public Resume[] getAllResumes() {
        return Arrays.copyOf(storage, size);
    }

    public void deleteResume(Object searchKey) {
        remove(searchKey);
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

    abstract Object getKey(String uuid);

    abstract void insert(Resume r, Object searchKey);

    abstract void remove(Object searchKey);
}
