package com.urise.webapp.model;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    // При создании незполненного объекта задаем uuid по-умолчанию (случайным образом) и
    // вызываем следующий конструктор. Так можно создать целый набор.
    public Resume() {
        this(UUID.randomUUID().toString());
    }
    // задаем указанный uuid для резюме
    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    /**
     * Переопределяем equals()
     * Смысл переопределения такой: если два разных объекта имеют одинаковый uuid, то они равны.
     * Теперь вопрос - что за разные объекты такие?
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }
}
