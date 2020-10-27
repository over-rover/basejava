public class MainTestArrayStorage {
    // Класс к удалению,, так как для тестирования используются тестовые классы.
    // Но рука не поднимается удалять. Вдруг пригодится еще. потом удалю.
    /*private static final Storage ARRAY_STORAGE = new MapStorageUUID();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "name1");
        final Resume r2 = new Resume("uuid2", "name2");
        final Resume r3 = new Resume("uuid3", "name3");

        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.save(r1);
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        ARRAY_STORAGE.save(r2);
        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.save(r3);
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();

        final Resume r4 = new Resume("uuid4", "name4");
        System.out.println("Save r4 " + r4.getUuid() + " result:");
        ARRAY_STORAGE.save(r4);
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get r2 result: " + ARRAY_STORAGE.get(r2.getUuid()));
        System.out.println("Get r4 result: " + ARRAY_STORAGE.get(r4.getUuid()));

        //Будет брошено исключение, выполнение программы завершится на этом этапе.
        *//*System.out.println("Обращемся к несуществующему резюме dummy");
        System.out.println(ARRAY_STORAGE.get("dummy"));*//*

        //Будет брошено исключение, выполнение программы завершится на этом этапе.
        *//*ARRAY_STORAGE.delete("dummy");
        System.out.println("Пытаемся удалить несуществующее резюме dummy");*//*

        System.out.println("Делаем update " + r1.getUuid());
        ARRAY_STORAGE.update(r1);

        System.out.println("Удаляем резюме " + r1.getUuid());
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Удаляем резюме " + r3.getUuid());
        ARRAY_STORAGE.delete(r3.getUuid());
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Очищаем хранилище резюме");
        ARRAY_STORAGE.clear();
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        //System.out.print("Print All:\t");
        *//*for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.print(r + "\t");
        }
        System.out.println();*//*

*//*        for (ARRAY_STORAGE.Entry<String, Resume> entry : ARRAY_STORAGE.entrySet()) {
            System.out.println(entry.getValue());
        }*//*
    }*/


}
