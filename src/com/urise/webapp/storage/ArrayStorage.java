package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected List<Resume> getAllSortedResumes() {
        List<Resume> tempList = new ArrayList<>(Arrays.asList(storage).subList(0, super.size));
        Collections.sort(tempList);
        return tempList;
    }

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
