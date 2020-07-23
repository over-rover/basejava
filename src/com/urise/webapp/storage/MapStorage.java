
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public void deleteAll() {
        storage.clear();
    }

    @Override
    void deleteResume(Object searchKey) {
        storage.remove(searchKey.toString());
    }

    @Override
    Resume[] getAllResumes() {
        Collection<Resume> resumes = storage.values();
        return resumes.toArray(new Resume[0]);
    }

    @Override
    Object getKey(String uuid) {
        return uuid;
    }

    @Override
    Resume getResume(Object searchKey) {
        return storage.get(searchKey.toString());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.get(searchKey.toString()) != null;
    }

    @Override
    void saveResume(Resume r, Object searchKey) {
        storage.put(searchKey.toString(), r);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    void updateResume(Resume r, Object searchKey) {
        storage.replace(searchKey.toString(), r);
    }
}
