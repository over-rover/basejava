package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_3 = "uuid8";
    private static final String UUID_1 = "uuid3";
    private static final String UUID_2 = "uuid5";
    private static final String UUID_4 = "uuid9";
    private static Resume r1 = new Resume(UUID_1);
    private static Resume r2 = new Resume(UUID_2);
    private static Resume r3 = new Resume(UUID_3);
    private static Resume r4 = new Resume(UUID_4);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(r1);
        collection.add(r2);
        collection.add(r3);
        collection.add(r4);

        /*Пример неправильного кода.
        При переборе элементов коллекции пытаемся изменить(удалить) один из элементов.
        Это приводит к ConcurrentModificationException*/
        /*for (Resume r : collection) {
            if (r.getUuid().equals(UUID_2)) {
                collection.remove(r);
            }
            System.out.println(collection.toString());
        }*/

        /*Пример того, как нужно работать с элементами коллекции в процессе итерации*/
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            if (r.getUuid().equals(UUID_2)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());
        /*Idea предлагает заменить цикл на метод Collection.removeIf*/


        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, r1);
        map.put(UUID_2, r2);
        map.put(UUID_3, r3);
        map.put(UUID_4, r4);

        /*Пример направильной итерации в коллекции HashMap*/
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }
        /*Мы берем из коллекции массив ключей, перебираем этот массив и его элементы
         * сравниваем с элементами коллекции.
         * Получается, дважды, обращаемся к коллекции - а это дорогая оперция*/


        /*Пример правильной итерации по коллекции HashMap*/
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
