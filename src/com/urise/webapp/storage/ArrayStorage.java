package com.urise.webapp.storage;

public class ArrayStorage extends AbstractArrayStorage {
    protected int findResumeIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}
