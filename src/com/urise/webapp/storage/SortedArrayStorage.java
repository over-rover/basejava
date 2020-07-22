package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected Object getKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    protected void insert(Resume r, Object searchKey) {
        // проверка на возможное переполнение произведена в save().
        int index = (int) searchKey;
        index = -(index + 1); // точка вставки резюме
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
    }

    protected void remove(Object searchKey) {
        int index = (int) searchKey;
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }
}
