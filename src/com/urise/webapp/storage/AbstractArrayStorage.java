package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void deleteResume(Integer searchKey) {
        remove(searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected List<Resume> createListFromStorage() {
        return new ArrayList<>(Arrays.asList(storage).subList(0, size));
    }

    @Override
    protected Resume getResume(Integer searchKey) {
        return storage[searchKey];
    }

    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected void saveResume(Resume r, Integer searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("storage[] overflow!", r.getUuid());
        }
        insert(r, searchKey);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void updateResume(Resume r, Integer searchKey) {
        storage[searchKey] = r;
    }

    protected abstract void insert(Resume r, Integer searchKey);

    protected abstract void remove(Integer searchKey);
}