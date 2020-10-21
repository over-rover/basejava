
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove(searchKey.toString());
    }

    //К удалению, поскольку переходим на getAllSorted()
    /*@Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }*/

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> tempList = new ArrayList<Resume>(storage.values());
        tempList.sort(RESUME_COMPARATOR);
        return tempList;
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
