package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface Storage {

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    Resume[] getAll();
    // Сделать рефакторинг, заменив Resume[] getAll() на
    // List<Resume> list = getAllSorted();

    void delete(String uuid);

    void clear();

    int size();
}