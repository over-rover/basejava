package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

    public abstract class AbstractArrayStorageTest {
    //public class AbstractArrayStorageTest {
    // Поясни, пожалуйста, почему джава ругается без модификатора abstract?
    private Storage storage;
    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid5";
    private static final String UUID_3 = "uuid8";
    Resume r1, r2, r3;


    public AbstractArrayStorageTest(Storage storage){
        this.storage = storage;
    }
    /* логично было бы, чтобы у объекта SortedArrayStorage элементы были отсортированы
    (uuid3, uuid5, uuid8), а у ArrayStorage шли в произвольном порядке. В текущем варианте
    нужно ручками корректировать порядок uuid-ов в зависимости от получаемого объекта.
    Как-то не очень.
    */

    @Before
    public void setUp() {
        storage.clear();
        r1 = new Resume(UUID_1);
        r2 = new Resume(UUID_2);
        r3 = new Resume(UUID_3);
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
    }

    @Test
    public void testSave() {
        Resume r4 = new Resume("uuid7");
        storage.save(r4);
        assertEquals(r4, storage.get("uuid7"));
    }

    @Test
    public void testSaveThrowsExceptionForStorageOverflow() {
        try {
            while (storage.size() <= AbstractArrayStorage.STORAGE_LIMIT) {
                storage.save(new Resume());
            }
        }
        catch (StorageException e) {
            if (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
                fail("ВНИМАНИЕ!!! Исключение брошено, хотя массив еще не переполнен. Тест не пройден");
            } else {
                System.out.println("Резюме " + e.getUuid() + " вызвало переполнение массива. " +
                        "Брошено исключение. Тест пройден.");
            }
        }
    }
    // AbstractArrayStorage.STORAGE_LIMIT имеет модификатор protected.
    // Мы же не должны его видеть отсюда?

    @Test
    public void update() {
        r1 = new Resume(UUID_1);
        storage.update(r1);
        assertEquals(r1, storage.get(UUID_1));
        //не знаю как проверить, т.к. update ничего не обновляет.
    }

    @Test(expected = NotExistStorageException.class)
    public void testUpdateThrowsExceptionNotExists() {
        Resume r4 = new Resume();
        storage.update(r4);
    }

    @Test
    public void get() {
        assertEquals(r1, storage.get(UUID_1));
        assertEquals(r2, storage.get(UUID_2));
        assertEquals(r3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void testGetThrowsExceptionNotExists() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Assert.assertEquals(3,storage.size());
        Resume[] storageCopy = storage.getAll();
        assertEquals(storage.get(UUID_1), storageCopy[0]);
        assertEquals(storage.get(UUID_2), storageCopy[1]);
        assertEquals(storage.get(UUID_3), storageCopy[2]);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_2);
        assertEquals(2, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void testDeleteThrowsExceptionNotExists() {
        storage.delete("dummy");
    }

    @Test // проверим, что после обнуления массива size == 0
    public void clearAssertSizeIsNull() {
        storage.clear();
        assertEquals("must return 0", 0, storage.size());
    }

    @Test
    public void size() {
        assertEquals(3,storage.size());
    }

    /*@Test
    public void testGetIndex() {
        assertEquals(0, ge);
    }*/
    // Методы getIndex(), insert(), remove() протестировать не получается -
    // их почему-то не видно ни отсюда, ни из наследника.
}