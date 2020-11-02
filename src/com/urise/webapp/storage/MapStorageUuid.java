
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorageUuid extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove(searchKey.toString());
    }

    protected List<Resume> createListFromStorage() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(searchKey.toString());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey(searchKey.toString());
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        storage.put(searchKey.toString(), r);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        storage.replace(searchKey.toString(), r);
    }
}