package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public List<Resume> getAllSorted() {
        List<Resume> tempList = new ArrayList<Resume>(Arrays.asList(storage).subList(0, super.size));
        tempList.sort(RESUME_COMPARATOR);
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
