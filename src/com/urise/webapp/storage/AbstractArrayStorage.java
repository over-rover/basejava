package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size; // полезный размер массива

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        // может вернуть от [-(0+1) до -(10000+1)] если элемент не найден
        // или от [0 до (10000-1)], если элемент есть в массиве
        if (index >= 0) {
            System.out.println("SAVE ERROR: Resume already exists");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Error!!! storage[] overflow");
        } else {
            insert(r);
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("UPDATE ERROR: Resume doesn't exist");
        } else {
            storage[index] = r;
            System.out.println("UPDATE is successful");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.print("GET ERROR: Resume doesn't exist \t");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("DELETE ERROR: Resume doesn't exist");
        } else {
            extract(index);
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insert(Resume r);

    protected abstract void extract(int index);
}
