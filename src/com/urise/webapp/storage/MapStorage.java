
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new HashMap<>();

    public int size() {
        return storage.size();
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

    @Override
    void deleteResume(Object searchKey) {
        storage.replace((String) searchKey, getResume(searchKey));
    }

    @Override
    Resume[] getAllResumes() {
        return new Resume[0];
    }

    @Override
    Object getKey(String uuid) {
        return (storage.get(uuid) == null) ? null : storage.get(uuid).getUuid();
    }

    @Override
    Resume getResume(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    void saveResume(Resume r, Object searchKey) {
        storage.put((String) searchKey, r);
    }

    @Override
    void updateResume(Resume r, Object searchKey) {
        storage.replace((String) searchKey, r);
    }
}
