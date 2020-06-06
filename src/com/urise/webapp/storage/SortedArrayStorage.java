package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {
    private int insertIndex;

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        /*Далее реализован двоичный поиск по аналогии с методом Arrays.binarySearch()
         * Однако, есть нюанс. При сравнении строк "uuid8" оказывается больше, чем "uuid23"
         * Возможно из-за отсутствия в коде записи Comparable midVal = (Comparable)a[mid]
         * По словам Татьяны Arrays.binarySearch() дает лексикографическое сравнение строк
         * и такой проблемы там нет.*/
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = searchKey.compareTo(storage[mid]);
            if (cmp > 0)
                low = mid + 1;
            else if (cmp < 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        insertIndex = low; // storage[insertIndex] - точка вставки резюме
        return -(low + 1);  // key not found.
    }

    protected void insert(Resume r) {
        for (int i = size; i >= insertIndex; i--) {
            storage[i + 1] = storage[i];
            // проверка на возможное переполнение произведена в save().
        }
        // IDEA предложила альтернативу, но она вообще не дружественная
        // System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size + 1 - insertIndex);

        storage[insertIndex] = r;
        size++;
    }

    protected void extract(int index) {
        System.arraycopy(storage, index + 1, storage, index, size);
        size--;
    }
}
