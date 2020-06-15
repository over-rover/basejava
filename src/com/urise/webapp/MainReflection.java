package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());

        field.get(r);
        // метод get(r) вызывает Unhandled Exception. Решаем проблему самым простым образом -
        // бросаем Throw. Idea подсказывает.
        System.out.println(r);

        field.set(r, "changed_uuid");
        System.out.println(r);

        // выводим все поля класса
        Field[] fields = r.getClass().getDeclaredFields();
        for(Field i : fields) {
            System.out.println("Поле: " + i);
        }

        // выводим все методы класса
        Method[] methods = r.getClass().getDeclaredMethods();
        for(Method i : methods) {
            System.out.println("Метод: " + i);
        }

        // выводим метод toString()
        Method method = r.getClass().getDeclaredMethod("toString");
        // Idea еще одно исключение нарисовала
        System.out.println("method toString() " + method);
    }
}
