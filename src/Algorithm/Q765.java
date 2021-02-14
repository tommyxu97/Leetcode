package Algorithm;

public class Q765 {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        int n = row.length;
        for (int i = 0; i < n - 1; i += 2) {
            int temp = row[i] ^ 1;
            if (row[i + 1] == temp) continue;
            int index = i + 2;
            while (index < n && row[index] != temp) index++;
            swap(row, i + 1, index);
            res++;
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
