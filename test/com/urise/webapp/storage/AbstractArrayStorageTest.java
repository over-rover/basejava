package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void shouldThrowExceptionOnSaveIfStorageOverflowTest() {
        try {
            while (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
                storage.save(new Resume("fullName"));
            }
        } catch (StorageException e) {
            fail("ВНИМАНИЕ!!! Исключение брошено, хотя массив еще не переполнен. Тест не пройден");
        }
        storage.save(new Resume("fullName"));
    }
}