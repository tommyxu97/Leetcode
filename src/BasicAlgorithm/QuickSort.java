package BasicAlgorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 9, 7, 12, 3, 3, 10, -2, 100, 2, 1, 8, 6, -10, 150, 18, 24, 17, 18, 2, 6, 8};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = partition(arr, start, end);
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int num = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] >= num) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= num) i++;
            arr[j] = arr[i];
        }
        arr[i] = num;
        return i;
    }
}
