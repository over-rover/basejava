package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;

public abstract class AbstractStorage implements Storage {
    protected static final Comparator<Resume> RESUME_COMPARATOR =
            (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

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

    protected abstract void deleteResume(Object searchKey);

    protected abstract Object getKey(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void saveResume(Resume r, Object searchKey);

    protected abstract void updateResume(Resume r, Object searchKey);
}
