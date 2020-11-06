package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        storage.remove((int) searchKey); // remove требует примитивный int
    }

    @Override
    protected List<Resume> createListFromStorage() {
        return new ArrayList<>(storage);
    }

    @Override
    protected Integer getKey(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

    @Override
    protected Resume getResume(Integer searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected void saveResume(Resume r, Integer searchKey) {
        storage.add(r);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, Integer searchKey) {
        storage.set(searchKey, r);
    }
}