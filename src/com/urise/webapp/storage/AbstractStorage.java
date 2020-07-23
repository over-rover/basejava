package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        Object searchKey = getKeyAndThrowExceptionIfResumeExist(r.getUuid());
        saveResume(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        Object searchKey = getKeyAndThrowExceptionIfResumeNotExist(r.getUuid());
        updateResume(r, searchKey);
        System.out.println("UPDATE is successful");
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getKeyAndThrowExceptionIfResumeNotExist(uuid);
        return getResume(searchKey);
    }

    @Override
    public Resume[] getAll() {
        return getAllResumes();
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getKeyAndThrowExceptionIfResumeNotExist(uuid);
        deleteResume(searchKey);
    }

    @Override
    public void clear() {
        deleteAll();
    }

    private Object getKeyAndThrowExceptionIfResumeExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (isExist(searchKey)) throw new ExistStorageException(uuid);
        return searchKey;
    }

    private Object getKeyAndThrowExceptionIfResumeNotExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (!isExist(searchKey)) throw new NotExistStorageException(uuid);
        return searchKey;
    }

    abstract void deleteAll();

    abstract void deleteResume(Object searchKey);

    abstract Resume[] getAllResumes();

    abstract Object getKey(String uuid);

    abstract Resume getResume(Object searchKey);

    abstract boolean isExist(Object searchKey);

    abstract void saveResume(Resume r, Object searchKey);

    abstract void updateResume(Resume r, Object searchKey);
}
