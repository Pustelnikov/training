public class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minEl = arr[i];
            int minIn = i;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j + 1] < minEl) {
                    minEl = arr[j + 1];
                    minIn = j + 1;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIn];
            arr[minIn] = tmp;
        }
    }
}
