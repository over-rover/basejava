package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("uuid1111");
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println("Поле называется: " + field.getName());

        field.get(r);
        // метод get(r) может вызвать Unhandled Exception. Решаем проблему самым простым образом -
        // бросаем Throw. Idea подсказывает IllegalAccessException.
//        System.out.println("Его значение: " + r);

        field.set(r, "uuid2222");
//        System.out.println("Заменили поле uuid значением: " + r);

        // выводим все поля класса
        Field[] fields = resumeClass.getDeclaredFields();
        for (Field i : fields) {
            System.out.println("Список всех полей класса: " + i);
        }

        // выводим все методы класса
        // Idea заставляет предупредить о NoSuchMethodException
        Method[] methods = resumeClass.getDeclaredMethods();
        for (Method i : methods) {
            System.out.println("Список всех методов класса: " + i);
        }

        // выводим метод toString()
        System.out.println("method toString() " + resumeClass.getDeclaredMethod("toString"));
        System.out.println("method toString() " + methods[1]);

        // Реализуем обращение к методу toString() нашего объекта  согласно разбору ДЗ
        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);
    }
}
