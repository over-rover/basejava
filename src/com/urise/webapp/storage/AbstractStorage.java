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
        Object searchKey = getSearchKey(r.getUuid());
        updateResume(r, searchKey);
        System.out.println("UPDATE is successful");
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        deleteResume(searchKey);
    }

    private Object getKeyAndThrowExceptionIfResumeExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (isExist(searchKey)) throw new ExistStorageException(uuid);
        return searchKey;
    }

    private Object getSearchKey(String uuid) {
        Object searchKey = getKey(uuid);
        if (!isExist(searchKey)) throw new NotExistStorageException(uuid);
        return searchKey;
    }

    @Override
    public abstract void clear();

    abstract void deleteResume(Object searchKey);

    @Override
    public abstract Resume[] getAll();

    protected abstract Object getKey(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void saveResume(Resume r, Object searchKey);

    protected abstract void updateResume(Resume r, Object searchKey);
}
