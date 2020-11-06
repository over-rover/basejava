
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorageUuid extends AbstractStorage<String> {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void deleteResume(String searchKey) {
        storage.remove(searchKey);
    }

    protected List<Resume> createListFromStorage() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getResume(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected void saveResume(Resume r, String searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, String searchKey) {
        storage.replace(searchKey, r);
    }
}
