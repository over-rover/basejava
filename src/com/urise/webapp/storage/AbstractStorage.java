package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getKeyIfResumeNotExist(r.getUuid());
        saveResume(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getKeyIfResumeExist(r.getUuid());
        updateResume(r, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getKeyIfResumeExist(uuid);
        return getResume(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> tempList = createListFromStorage();
        Collections.sort(tempList);
        return tempList;
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getKeyIfResumeExist(uuid);
        deleteResume(searchKey);
    }

    private SK getKeyIfResumeNotExist(String uuid) {
        SK searchKey = getKey(uuid);
        if (!isExist(searchKey)) return searchKey;
        LOG.warning("Resume " + uuid + " already exists");
        throw new ExistStorageException(uuid);
    }

    private SK getKeyIfResumeExist(String uuid) {
        SK searchKey = getKey(uuid);
        if (isExist(searchKey)) return searchKey;
        LOG.warning("Resume " + uuid + " doesn't exist");
        throw new NotExistStorageException(uuid);
    }

    protected abstract void deleteResume(SK searchKey);

    protected abstract SK getKey(String uuid);

    protected abstract Resume getResume(SK searchKey);

    protected abstract List<Resume> createListFromStorage();

    protected abstract boolean isExist(SK searchKey);

    protected abstract void saveResume(Resume r, SK searchKey);

    protected abstract void updateResume(Resume r, SK searchKey);
}
