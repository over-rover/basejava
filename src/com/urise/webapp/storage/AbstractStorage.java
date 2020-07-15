package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {
    protected int index;

    public void save(Resume r) {
        index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r);
        }
    }

    public void update(Resume r) {
        index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(r);
            System.out.println("UPDATE is successful");
        }
    }

    public Resume get(String uuid) {
        index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume();
    }

    public Resume[] getAll() {
        return getAllResumes();
    }

    public void delete(String uuid) {
        index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume();
        }
    }

    public void clear() {
        deleteAll();
    }

    abstract void deleteAll();

    abstract void deleteResume();

    abstract Resume[] getAllResumes();

    abstract int getIndex(String uuid);

    abstract Resume getResume();

    abstract void saveResume(Resume r);

    abstract void updateResume(Resume r);
}
