import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.ListStorage;
import com.urise.webapp.storage.MapStorage;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

import java.util.Map;

public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new MapStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid09");
        final Resume r2 = new Resume("uuid14");
        final Resume r3 = new Resume("uuid16");

        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.save(r1);
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        ARRAY_STORAGE.save(r2);
        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.save(r3);
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();

        final Resume r4 = new Resume("uuid10");
        System.out.println("Save r4 " + r4.getUuid() + " result:");
        ARRAY_STORAGE.save(r4);
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get r2 result: " + ARRAY_STORAGE.get(r2.getUuid()));
        System.out.println("Get r4 result: " + ARRAY_STORAGE.get(r4.getUuid()));

        System.out.println("Обращемся к несуществующему резюме uuid42");
        System.out.println(ARRAY_STORAGE.get("uuid42"));

        System.out.println("Пытаемся удалить несуществующее резюме uuid42");
        ARRAY_STORAGE.delete("uuid42");

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

        System.out.println("Очищаем массив резюме");
        ARRAY_STORAGE.clear();
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        //System.out.print("Print All:\t");
        /*for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.print(r + "\t");
        }
        System.out.println();*/

/*        for (ARRAY_STORAGE.Entry<String, Resume> entry : ARRAY_STORAGE.entrySet()) {
            System.out.println(entry.getValue());
        }*/
    }


}
