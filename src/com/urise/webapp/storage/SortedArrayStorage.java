package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> BY_UUID_RESUME_COMPARATOR =
            Comparator.comparing(Resume::getUuid);

    @Override
    protected Object getKey(String uuid) {
        Resume searchKey = new Resume(uuid, "noMatterName");
        return Arrays.binarySearch(storage, 0, size, searchKey, BY_UUID_RESUME_COMPARATOR);
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
