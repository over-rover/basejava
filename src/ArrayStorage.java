import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];


    void clear() {
        for(int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        while (!storage[i].uuid.equals(uuid) && i < size()) {
            i++;
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i = 0;
        while (!storage[i].uuid.equals(uuid) && i < size()) {
            i++;
        }
        storage[i] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int i = 0;
        while(storage[i] != null) {
            i++;
        }
        return i;
    }
}
