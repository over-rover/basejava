package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Resume r = new Resume("uuid1111");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println("Поле называется: " + field.getName());

        field.get(r);
        // метод get(r) может вызвать Unhandled Exception. Решаем проблему самым простым образом -
        // бросаем Throw. Idea подсказывает IllegalAccessException.
        System.out.println("Его значение: " + r);

        field.set(r, "uuid2222");
        System.out.println("Заменили поле uuid значением: " + r);

        // выводим все поля класса
        Field[] fields = r.getClass().getDeclaredFields();
        for(Field i : fields) {
            System.out.println("Список всех полей класса: " + i);
        }

        // выводим все методы класса
        // Idea заставляет предупредить о NoSuchMethodException
        Method[] methods = r.getClass().getDeclaredMethods();
        for(Method i : methods) {
            System.out.println("Список всех методов класса: " + i);
        }

        // выводим метод toString()
        Method method = r.getClass().getDeclaredMethod("toString");
        System.out.println("method toString() " + method);

        System.out.println("method toString() " + methods[1]);
    }
}
