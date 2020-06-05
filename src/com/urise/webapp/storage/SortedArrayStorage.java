package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        int low = 0;
        int high = size - 1;
        int step = 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            int cmp = searchKey.compareTo(storage[mid]);
            System.out.println(step +" step (beg): " + "low = " + low + "\t" + "high = " + high + "\t" + "mid = " + mid + "\t" + "cmp = " + cmp);

            if (cmp > 0)
                low = mid + 1;
            else if (cmp < 0)
                high = mid - 1;
            else
                return mid; // key found
            System.out.println(step +" step (end): " + "low = " + low + "\t" + "high = " + high + "\t" + "mid = " + mid + "\t" + "cmp = " + cmp);
            if (low < high)
                System.out.println(Arrays.toString(Arrays.copyOfRange(storage, low, high+1)));
            step++;
        }

        return -(low + 1);  // key not found.
        /*В этом случае нужно сдвигать все элементы, начиная со storage[low], а
        * на место  storage[low] вставлять новое резюме*/

        //return Arrays.binarySearch(storage, 0, size, searchKey);
        /*
         * В binarySearch() сравниваются объекты типа Resume, а у нас на входе String,
         * поэтому пришлось придумывать костыли и создавать промежуточный объект searchKey и
         * присваивать ему uuid
         */
    }

    protected void insert(Resume r) {
        storage[size] = r;
        size++;
        /*if (size == 0) {
            storage[0] = r;
            System.out.println("Нулевое резюме  " + storage[0].getUuid());
            size++;
        } else {

            int low = 0, high = size - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (r.compareTo(storage[mid]) > 0) {
                    if (r.compareTo(storage[mid + 1]) > 0) {
                        low = mid + 1;
                    } else {
                        // вставляем резюме между storage[mid] и storage[mid+1]
                        spread(r, mid);
                    }
                } else {
                    if (r.compareTo(storage[mid - 1]) < 0) {
                        high = mid - 1;
                    } else {
                        // вставляем резюме между storage[mid-1] и storage[mid]
                        spread(r, mid - 1);
                    }
                }
            }

        }*/
    }

    private void spread(Resume r, int index) {
        size++; // может быть переполнение
        for (int i = size; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        // IDEA предложила такую альтернативу
        //if (size - index >= 0) System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index + 1] = r;
    }
}
