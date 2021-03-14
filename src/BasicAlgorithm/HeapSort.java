package BasicAlgorithm;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 9, 7, 12, 3, 3, 10, -2, 100, 2, 1, 8, 6, -10, 150, 18, 24, 17, 18, 2, 6, 8};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] arr) {
        heapSort(arr, arr.length);
    }

    public void heapSort(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, 0);
            swap(arr, 0, i);
        }
    }

    private void heapify(int[] arr, int n, int parent) {
        int largest = parent;
        int l = parent * 2 + 1;
        int r = parent * 2 + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != parent) {
            swap(arr, parent, largest);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
