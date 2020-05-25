package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    protected int findResumeIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
        /*
         * В binarySearch() сравниваются объекты типа Resume, а у нас на входе String,
         * поэтому пришлось придумывать костыли и создавать промежуточный объект searchKey и
         * присваивать ему uuid
         */
    }

    /* В ДЗ сказано: В SortedArrayStorage ХРАНИТЕ элементы отсортированными.
     * То есть нужно в классе SortedArrayStorage создать Resume[] sortedStorage = new Resume[size] ?
     * Кабы не указание "хранить в SortedArrayStorage", я бы попробовал сортировать и
     * изменять storage[size] - как-то логичнее кажется.
     *
     * Собственно теперь по сортировке. Как можно понять, что строка "uuid1" меньше "uuid23"?
     * split() на строку и число,а потом сравнивать числа 1 и 23?
     * */
}
