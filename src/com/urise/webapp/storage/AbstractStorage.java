package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        Object searchKey = getKey(r.getUuid());
        checkIfResumeExist(r.getUuid(), searchKey);
        saveResume(r, searchKey);
    }

    public void update(Resume r) {
        Object searchKey = getKey(r.getUuid());
        checkIfResumeNotExist(r.getUuid(), searchKey);
        updateResume(r, searchKey);
        System.out.println("UPDATE is successful");
    }

    public Resume get(String uuid) {
        Object searchKey = getKey(uuid);
        checkIfResumeNotExist(uuid, searchKey);
        return getResume(searchKey);
    }

    public Resume[] getAll() {
        return getAllResumes();
    }

    public void delete(String uuid) {
        Object searchKey = getKey(uuid);
        checkIfResumeNotExist(uuid, searchKey);
        deleteResume(searchKey);
    }

    public void clear() {
        deleteAll();
    }

    private void checkIfResumeExist(String uuid, Object searchKey) {
        if ((searchKey instanceof Integer && (int) searchKey >= 0) ||
                searchKey instanceof String) {
            throw new ExistStorageException(uuid);
        }
    }

    private void checkIfResumeNotExist(String uuid, Object searchKey) {
        if ((searchKey instanceof Integer && (int) searchKey < 0) || searchKey == null) {
            throw new NotExistStorageException(uuid);
        }
    }

    abstract void deleteAll();

    abstract void deleteResume(Object searchKey);

    abstract Resume[] getAllResumes();

    abstract Object getKey(String uuid);

    abstract Resume getResume(Object searchKey);

    abstract void saveResume(Resume r, Object searchKey);

    abstract void updateResume(Resume r, Object searchKey);
}
