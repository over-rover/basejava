package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    @Override
    public void save(Resume r) {
        SK searchKey = getKeyIfResumeNotExist(r.getUuid());
        saveResume(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        SK searchKey = getKeyIfResumeExist(r.getUuid());
        updateResume(r, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = getKeyIfResumeExist(uuid);
        return getResume(searchKey);
    }

    // переделал под шаблонный метод. Конечно, уменьшил код на десяток строк, но при этом
    // сортирую List, полученный из SortedArray (масло маслом мажу). Ресурсы транжирим.
    // Но, видимо, есть какой-то смысл.
    // В тестах, например, теперь можно не париться с тем, что при инициализации SortedArray storage,
    // он должен быть отсортирован, а все остальные реализации должны быть проинициализированы в произвольном порядке.
    @Override
    public List<Resume> getAllSorted() {
        List<Resume> tempList = createListFromStorage();
        Collections.sort(tempList);
        return tempList;
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = getKeyIfResumeExist(uuid);
        deleteResume(searchKey);
    }

    private SK getKeyIfResumeNotExist(String uuid) {
        SK searchKey = getKey(uuid);
        if (!isExist(searchKey)) return searchKey;
        throw new ExistStorageException(uuid);
    }

    private SK getKeyIfResumeExist(String uuid) {
        SK searchKey = getKey(uuid);
        if (isExist(searchKey)) return searchKey;
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
