package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove((int) searchKey);
    }

    /*@Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }*/

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> tempList = new ArrayList<Resume>(storage);
        //Collections.copy(storage, tempList);
        tempList.sort(RESUME_COMPARATOR);
        return tempList;
    }

    @Override
    protected Object getKey(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        storage.set((int) searchKey, r);
    }
}