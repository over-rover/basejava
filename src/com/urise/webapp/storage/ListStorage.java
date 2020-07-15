package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    public int size() {
        return storage.size();
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

    @Override
    public void deleteResume() {
        storage.remove(index);
    }

    @Override
    public Resume[] getAllResumes() {
        return storage.toArray(new Resume[0]);
        /*https://javarush.ru/help/13126
         * https://overcoder.net/q/1896/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-arraylist-ltstringgt-%D0%B2-string-%D0%B2-java*/
    }

    @Override
    public int getIndex(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

    @Override
    public Resume getResume() {
        return storage.get(index);
    }

    @Override
    public void saveResume(Resume r) {
        storage.add(r);
    }

    @Override
    public void updateResume(Resume r) {
        storage.set(index, r);
    }
}
