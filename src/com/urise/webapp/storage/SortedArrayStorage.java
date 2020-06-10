package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    protected void insert(Resume r) {
        // проверка на возможное переполнение произведена в save().
        index = -(index + 1); // точка вставки резюме
        System.arraycopy(storage, index, storage, index + 1, size + 1 - index);
        storage[index] = r;
    }

    protected void remove(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }
}
