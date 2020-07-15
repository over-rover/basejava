package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    public void saveResume(Resume r) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("storage[] overflow!", r.getUuid());
        } else {
            // index равен -(точка_вставки + 1) для бинарного поиска и -1 для поиска перебором.
            insert(r);
            size++;
        }
    }

    public void updateResume(Resume r) {
        storage[index] = r;
    }

    public Resume getResume() {
        return storage[index];
    }

    public Resume[] getAllResumes() {
        return Arrays.copyOf(storage, size);
    }

    public void deleteResume() {
        remove();
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

    abstract void insert(Resume r);

    abstract void remove();
}
