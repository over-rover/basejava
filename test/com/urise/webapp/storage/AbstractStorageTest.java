package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private String fullName1 = "Aaaa";
    private String fullName2 = "Bbbb";
    private String fullName3 = "Cccc";
    private String fullName4 = "Dddd";

    private Resume r1 = new Resume(UUID_1, fullName1);
    private Resume r2 = new Resume(UUID_2, fullName2);
    private Resume r3 = new Resume(UUID_3, fullName3);
    private int initSize;

    protected AbstractStorageTest(Storage storage) {
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
        Resume r4 = new Resume(UUID_4, fullName4);
        storage.save(r4);
        assertSize(initSize + 1);
        assertGet(r4);
    }

    @Test(expected = ExistStorageException.class)
    public void shouldThrowExceptionOnSaveIfResumeExistsTest() {
        storage.save(r1);
    }

    @Test
    public void updateTest() {
        r3 = new Resume(r3.getUuid(), "fullNameUpdated");
        storage.update(r3);
        assertEquals(storage.get(UUID_3), r3);
    }

    @Test(expected = NotExistStorageException.class)
    public void shouldThrowExceptionOnUpdateIfResumeNotExistsTest() {
        storage.update(new Resume("dummy"));
    }

    @Test
    public void getTest() {
        assertGet(r1);
        assertGet(r2);
        assertGet(r3);
    }

    @Test(expected = NotExistStorageException.class)
    public void shouldThrowExceptionOnGetIfResumeNotExistsTest() {
        storage.get("dummy");
    }

    @Test
    public void getALLSortedTest() {
        List<Resume> expectedResumes = Arrays.asList(r1, r2, r3);
        storage.clear();
        storage.save(r1);
        storage.save(r3);
        storage.save(r2);
        assertEquals(expectedResumes, storage.getAllSorted());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteTest() {
        storage.delete(UUID_2);
        assertEquals(initSize - 1, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void shouldThrowExceptionOnDeleteIfResumeNotExistsTest() {
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

    private void assertSize(int expectedSize) {
        assertEquals(expectedSize, storage.size());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }
}