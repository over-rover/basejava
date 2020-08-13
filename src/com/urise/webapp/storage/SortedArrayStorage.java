package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, new ResumeComparator());
    }

    private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }

    @Override
    protected void insert(Resume r, int searchKey) {
        searchKey = -(searchKey + 1); // точка вставки резюме
        System.arraycopy(storage, searchKey, storage, searchKey + 1, size - searchKey);
        storage[searchKey] = r;
    }

    @Override
    protected void remove(int searchKey) {
        System.arraycopy(storage, searchKey + 1, storage, searchKey, size - 1 - searchKey);
    }
}
