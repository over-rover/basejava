package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        Object searchKey = getKeyIfResumeNotExist(r.getUuid());
        saveResume(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        Object searchKey = getKeyIfResumeExist(r.getUuid());
        updateResume(r, searchKey);
        System.out.println("UPDATE is successful");
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getKeyIfResumeExist(uuid);
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getKeyIfResumeExist(uuid);
        deleteResume(searchKey);
    }

    private Object getKeyIfResumeNotExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (!isExist(searchKey)) return searchKey;
        throw new ExistStorageException(uuid);
    }

    private Object getKeyIfResumeExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (isExist(searchKey)) return searchKey;
        throw new NotExistStorageException(uuid);
    }

    // Можно удалить, оказывается. То есть абстрактный класс не обязательно должен реализовать все методы интерфейса
    /*@Override
    public abstract void clear();*/

    abstract void deleteResume(Object searchKey);

    /*@Override
    public abstract Resume[] getAll();*/

    protected abstract Object getKey(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void saveResume(Resume r, Object searchKey);

    protected abstract void updateResume(Resume r, Object searchKey);
}
