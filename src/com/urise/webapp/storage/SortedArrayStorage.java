package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected List<Resume> getAllSortedResumes() {
        List<Resume> tempList = new ArrayList<>(Arrays.asList(storage).subList(0, super.size));
        return tempList;
    }

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

    private static final Comparator<Resume> BY_UUID_RESUME_COMPARATOR =
            (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());
}
