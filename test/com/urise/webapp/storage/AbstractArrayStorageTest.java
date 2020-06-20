package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {
    private Storage storage = new SortedArrayStorage();
    int sizeExpected;
    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid8";
    private static final String UUID_3 = "uuid23";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
        sizeExpected = 3;
        // предполагаем, что методы clear() save() работают корректно.
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Assert.assertEquals(sizeExpected,storage.size());
        Resume[] storageCopy = storage.getAll();
        assertEquals(storage.get(UUID_1), storageCopy[0]);
        assertEquals(storage.get(UUID_2), storageCopy[1]);
        assertEquals(storage.get(UUID_3), storageCopy[2]);
        // Тест не проходит при записи uuid вида: uuid3, uuid8, uuid23.
        // Однако проходит при uuid03, uuid08, uuid23
        // Причина, скорее всего в Arrays.copyOf(). Я посмотрел реализацию - ничерта не понятно. Но
        // там используется метод Math.min() - может он не использует лексикографического сравнения?
    }

    @Test
    public void delete() {
    }

    @Test // проверим, что после обнуления массива size == 0
    public void clearAssertSizeIsNull() {
        storage.clear();
        assertEquals("must return 0", 0, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(sizeExpected,storage.size());
    }
}