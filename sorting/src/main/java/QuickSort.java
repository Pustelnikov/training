public class QuickSort {
    public static void sort(int[] arr, int left, int right) {
        int index = quickPart (arr, left, right);
        if (left < index - 1)
            sort(arr, left, index - 1);
        if (index < right)
            sort(arr, index, right);
    }

    private static int quickPart (int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }
}
