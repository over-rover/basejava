package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapStorageTest {
    private Storage storage = new MapStorage();

    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid5";
    private static final String UUID_3 = "uuid8";
    private static final String UUID_4 = "uuid9";
    private Resume r1 = new Resume(UUID_1);
    private Resume r2 = new Resume(UUID_2);
    private Resume r3 = new Resume(UUID_3);
    private int initSize;

    @Before
    public void setUp() {
        storage.clear();
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
        initSize = 3;
    }

    @Test
    public void sizeTest() {
        assertEquals(initSize, storage.size());
    }

    @Test
    public void getKey() {
    }

    @Test
    public void getResume() {
        assertGet(r3);
    }

    @Test
    public void saveResume() {
    }


    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }
}