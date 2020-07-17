package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        }
        saveResume(r, index);
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        }
        updateResume(r, index);
        System.out.println("UPDATE is successful");
        /*"а почему сообщение только к методу Update написано? А к другим методам?"
        * изменения, производимые другими методами, отслеживаются в main() выводом на экран.
        * Метод update() у нас неполноценный до тех пор, пока не будут введены поля помимо
        * final String uuid. uuid- это единственное поле класса, а обновить его невозможно.
        * То есть, на данном этапе это сообщение несет минимальный функионал, показывая, что мы
        * как-то отработали в методе update(). Оно уберется.
        * В общем же, подтверждения типа "успешно сохранено, обновлено, добавлено и т.д"
        * обязательно должны выводиться пользователю. Но такой задачи не ставилось.
        * Сообщение prnintln("Операция выполнена успешно") вывести не проблема. Есть ли смысл?
        * */
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    public Resume[] getAll() {
        return getAllResumes();
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        deleteResume(index);
    }

    public void clear() {
        deleteAll();
    }

    abstract void deleteAll();

    abstract void deleteResume(int index);

    abstract Resume[] getAllResumes();

    abstract int getIndex(String uuid);

    abstract Resume getResume(int index);

    abstract void saveResume(Resume r, int index);

    abstract void updateResume(Resume r, int index);
}
