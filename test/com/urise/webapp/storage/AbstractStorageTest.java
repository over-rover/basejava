package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid5";
    private static final String UUID_3 = "uuid8";
    private static final String UUID_4 = "uuid9";
    private Resume r1 = new Resume(UUID_1);
    private Resume r2 = new Resume(UUID_2);
    private Resume r3 = new Resume(UUID_3);
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
        Resume r4 = new Resume(UUID_4);
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
        storage.update(new Resume(UUID_1));
        assertEquals(r1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void shouldThrowExceptionOnUpdateIfResumeNotExistsTest() {
        storage.update(new Resume());
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

    /*@Test
    public void getAllTest() {
        Resume[] expectedResumes = {r1, r2, r3};
        Resume[] actualResumes = storage.getAll();
        //System.out.println(Arrays.toString(actualResumes));
        //Arrays.sort(actualResumes);
        //Arrays.sort()
        assertArrayEquals(expectedResumes, actualResumes);
    }*/

    @Test
    public void getALLSortedTest() {
        List<Resume> expectedResumes = new ArrayList<Resume>();
        expectedResumes.add(r1);
        expectedResumes.add(r2);
        expectedResumes.add(r3);
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