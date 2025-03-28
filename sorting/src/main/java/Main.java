import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new Random().ints(10, 0, 100).toArray();
        System.out.println("Original array: " + Arrays.toString(array));

        int[] bubbleArray = Arrays.copyOf(array, array.length);
        BubbleSort.sort(bubbleArray);
        System.out.println("Bubble sorted: " + Arrays.toString(bubbleArray));

        int[] selectionArray = Arrays.copyOf(array, array.length);
        SelectionSort.sort(selectionArray);
        System.out.println("Selection sorted: " + Arrays.toString(selectionArray));

        int[] insertionArray = Arrays.copyOf(array, array.length);
        InsertionSort.sort(insertionArray);
        System.out.println("Insertion sorted: " + Arrays.toString(insertionArray));

        int[] quickArray = Arrays.copyOf(array, array.length);
        QuickSort.sort(quickArray, 0, quickArray.length - 1);
        System.out.println("Quick sorted: " + Arrays.toString(quickArray));

        int[] mergeArray = Arrays.copyOf(array, array.length);
        MergeSort.sort(mergeArray, mergeArray.length);
        System.out.println("Merge sorted: " + Arrays.toString(mergeArray));
    }
}
