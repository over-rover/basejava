import com.urise.webapp.model.Resume;
//import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume();
        r1.setUuid("uuid12");
        final Resume r2 = new Resume();
        r2.setUuid("uuid14");
        final Resume r3 = new Resume();
        r3.setUuid("uuid16");
        final Resume r4 = new Resume();
        r4.setUuid("uuid18");
        final Resume r5 = new Resume();
        r5.setUuid("uuid22");
        final Resume r6 = new Resume();
        r6.setUuid("uuid28");
        final Resume r7 = new Resume();
        r7.setUuid("uuid30");
        final Resume r8 = new Resume();
        r8.setUuid("uuid32");
        final Resume r9 = new Resume();
        r9.setUuid("uuid35");
        final Resume r10 = new Resume();
        r10.setUuid("uuid38");
        final Resume r11 = new Resume();
        r11.setUuid("uuid41");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r6);
        ARRAY_STORAGE.save(r7);
        ARRAY_STORAGE.save(r8);
        ARRAY_STORAGE.save(r9);
        ARRAY_STORAGE.save(r10);
        ARRAY_STORAGE.save(r11);
        printAll();

        //System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("ищем несуществующее резюме " + ARRAY_STORAGE.get("uuid42"));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        /*System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        ARRAY_STORAGE.delete("dummy");
        ARRAY_STORAGE.update(r1);*/
       //printAll();

        /*ARRAY_STORAGE.delete(r1.getUuid());
        printAll();*/

        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.print(r + "\t");
        }
        System.out.println();
    }
}
