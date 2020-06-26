package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid5";
    private static final String UUID_3 = "uuid8";
    private Resume r1 = new Resume(UUID_1);
    private Resume r2 = new Resume(UUID_2);
    private Resume r3 = new Resume(UUID_3);
    private int initSize;


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
        initSize = 3;
    }

    @Test
    public void saveTest() {
        Resume r4 = new Resume("uuid7");
        storage.save(r4);
        assertEquals(initSize + 1, storage.size());
    }

    @Test
    public void saveThrowsExceptionForStorageOverflowTest() {
        try {
            while (storage.size() <= AbstractArrayStorage.STORAGE_LIMIT) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            if (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
                fail("ВНИМАНИЕ!!! Исключение брошено, хотя массив еще не переполнен. Тест не пройден");
            } else {
                System.out.println("Резюме " + e.getUuid() + " вызвало переполнение массива. " +
                        "Брошено исключение. Тест пройден.");
            }
        }
    }
    /*
     AbstractArrayStorage.STORAGE_LIMIT имеет модификатор protected.
     Думал, что из тестовых классов можно увидеть только public поля/методы
    */

    @Test
    public void updateTest() {
        r1 = new Resume(UUID_1);
        storage.update(r1);
        assertEquals(r1, storage.get(UUID_1));
        //не знаю как проверить, т.к. update ничего не обновляет.
    }

    @Test(expected = NotExistStorageException.class)
    public void updateThrowsExceptionNotExistsTest() {
        Resume r4 = new Resume();
        storage.update(r4);
    }

    @Test
    public void getTest() {
        assertEquals(r1, storage.get(UUID_1));
        assertEquals(r2, storage.get(UUID_2));
        assertEquals(r3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getThrowsExceptionNotExistsTest() {
        storage.get("dummy");
    }

    @Test
    public void getAllTest() {
        Assert.assertEquals(initSize, storage.size());
        Resume[] storageCopy = storage.getAll();
        assertEquals(storage.get(UUID_1), storageCopy[0]);
        assertEquals(storage.get(UUID_2), storageCopy[1]);
        assertEquals(storage.get(UUID_3), storageCopy[2]);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteTest() {
        storage.delete(UUID_2);
        assertEquals(initSize - 1, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteThrowsExceptionNotExistsTest() {
        storage.delete("dummy");
    }

    @Test
    public void clearSizeIsNullTest() {
        storage.clear();
        assertEquals("must return 0", 0, storage.size());
    }

    @Test
    public void sizeTest() {
        assertEquals(initSize, storage.size());
    }

    /*@Test
    public void getIndexTest() {
        assertEquals(0, ge);
    }*/
    /*
     Абстрактные методы getIndex(), insert(), remove() протестировать не получается -
     их не видно из тестовых классов.
    */
}