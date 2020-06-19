package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {
    private Storage storage = new SortedArrayStorage();
    int sizeExpected;
    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid8";
    private static final String UUID_3 = "uuid23";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
        sizeExpected = 3;
        // мы предположили, что методы clear() save() работают корректно?
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
    }

    @Test
    public void delete() {
    }

    @Test // проверим, что после обнуления массива size == 0
    public void clearAssertSizeIsNull() {
        storage.clear();
        assertEquals("must return 0", 0, storage.size());
    }

    @Test // проверим, что после обнуления массива его элементы становятся null
    public void clearAssertNullElements() {
        // тестируем метод storage.clear();
        // Для этого нам нужно получить доступ к элементам storage[0...size-1] и в цикле сравнить их с null
        // Однако, прямого доступа к storage[] нет. Имеется только getAll(), но я не уверен, что
        // он отрабатывает корректо. Предпочтительнее использовать рефлексию.
        // Но не получается, так как исследую объект класса SortedArrayStorage, а поля
        // и методы Родителя этот объект не показывает - к ним тоже нужно как-то подобраться.
        // По какому пути идти?

        // выводим все поля класса SortedArrayStorage
        Field[] fields = storage.getClass().getDeclaredFields();
        for(Field i : fields) {
            System.out.println("Список всех полей класса: " + i);
        }

        // выводим все методы класса SortedArrayStorage
        Method[] methods = storage.getClass().getDeclaredMethods();
        for(Method i : methods) {
            System.out.println("Список всех методов класса: " + i);
        }

        // Родитель
        System.out.println("Superclass: " + storage.getClass().getSuperclass());

    }

    @Test
    public void size() {
        Assert.assertEquals(sizeExpected,storage.size());
    }
}