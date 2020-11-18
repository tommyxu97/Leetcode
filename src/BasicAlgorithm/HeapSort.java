package BasicAlgorithm;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // TEST
        int[] test = new int[] {1, 4, 6, 5, 2, 7, 9, 2, 3, 8, 10};
        heapsort(test);
        System.out.println(Arrays.toString(test));
    }

    public static void heapsort(int[] arr) {
        heapsort(arr, arr.length);
    }

    public static void heapsort(int[] arr, int n) {
        // 建立大根堆
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            heapify(arr, n, i);
        }
        // 顺次取出最大的元素放在数组的最后面
        for (int i = n - 1; i >=0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // 调整堆
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            // 递归定义子堆
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
