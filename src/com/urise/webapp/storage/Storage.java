package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    //К удалению, поскольку переходим на getAllSorted()
    //Resume[] getAll();

    List<Resume> getAllSorted();

    void delete(String uuid);

    void clear();

    int size();
}