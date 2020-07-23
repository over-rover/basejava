package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    @Override
    public void deleteAll() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void deleteResume(Object searchKey) {
        remove((int) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume[] getAllResumes() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public Resume getResume(Object searchKey) {
        return storage[(int) searchKey];
    }

    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    public void saveResume(Resume r, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("storage[] overflow!", r.getUuid());
        }
        insert(r, (int) searchKey);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void updateResume(Resume r, Object searchKey) {
        storage[(int) searchKey] = r;
    }

    abstract void insert(Resume r, int searchKey);

    abstract void remove(int searchKey);
}