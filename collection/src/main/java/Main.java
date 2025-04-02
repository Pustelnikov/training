import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] testData = new Random().ints(9, 0, 100).toArray();

        System.out.println("""
                #############
                ### ArrayList ###
                #############
                """);

        System.out.println("""
                Test data array:
                """ + Arrays.toString(testData) + "\n");

        CustomList<Integer> arrayList = new CustomArrayList<>();

        for (int testDatum : testData) {
            arrayList.add(testDatum);
        }
        System.out.println("Just created and filled");
        System.out.println(arrayList.toString());

        arrayList.add(7777777);
        arrayList.add(7777777);
        arrayList.add(7777777);
        System.out.println("""
                public void add(T value);
                Added number 7777777 three times""");
        System.out.println(arrayList.toString());

        arrayList.add(7777777, 3);
        System.out.println("""
                public void add(T value, int index);
                Added number 7777777 at index 3""");
        System.out.println(arrayList.toString());

        System.out.println("""
                public T get(int index);
                Getting index 7""");
        System.out.println(arrayList.get(7) + "\n");

        System.out.println("""
                public void remove(T value);
                Removed number 7777777""");
        arrayList.remove(7777777);
        System.out.println(arrayList.toString());

        System.out.println("""
                public void sort();
                Just sorted""");
        arrayList.sort();
        System.out.println(arrayList.toString());

        System.out.println("""
                public void clear();
                Just cleared""");
        arrayList.clear();
        System.out.println(arrayList.toString());

        System.out.println("""
                #############
                ### LinkedList ###
                #############
                """);

        System.out.println("""
                Test data array:
                """ + Arrays.toString(testData) + "\n");

        CustomList<Integer> linkedList = new CustomLinkedList<>();

        for (int testDatum : testData) {
            linkedList.add(testDatum);
        }
        System.out.println("Just created and filled");
        System.out.println(linkedList.toString());

        linkedList.add(7777777);
        linkedList.add(7777777);
        linkedList.add(7777777);
        System.out.println("""
                public void add(T value);
                Added number 7777777 three times""");
        System.out.println(linkedList.toString());

        linkedList.add(7777777, 3);
        System.out.println("""
                public void add(T value, int index);
                Added number 7777777 at index 3""");
        System.out.println(linkedList.toString());

        System.out.println("""
                public T get(int index);
                Getting index 7""");
        System.out.println(linkedList.get(7) + "\n");

        System.out.println("""
                public void remove(T value);
                Removed number 7777777""");
        linkedList.remove(7777777);
        System.out.println(linkedList.toString());

        System.out.println("""
                public void sort();
                Just sorted""");
        linkedList.sort();
        System.out.println(linkedList.toString());

        System.out.println("""
                public void clear();
                Just cleared""");
        linkedList.clear();
        System.out.println(linkedList.toString());
    }
}
