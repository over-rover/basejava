import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size; // полезный размер массива


    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        // Запись while (!storage[i].uuid.equals(uuid) && storage[i] != null) приводила к исключению при достижении
        // null, так как значение строки сравнивалось с пустотой. Поменял местами условия
        int i = 0;
        while (storage[i] != null && !storage[i].uuid.equals(uuid)) {
            i++;
        }
        return storage[i];

        /* // Резервный способ. Пока мучился с while нарисовался этот вариант
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        return null;*/
    }

    void delete(String uuid) {
        int i = 0;
        while (storage[i] != null && !uuid.equals(storage[i].uuid)) {
            i++;
        }
        // при выходе из цикла индекс указывает или на позицию искомого uuid или позицию первого null
        if (i < size) {
            storage[i] = storage[size-1];
            storage[size-1] = null;
            size--;
        } else {
            System.out.println("Указанное значение не найдено. Проверьте правильность ввода");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
