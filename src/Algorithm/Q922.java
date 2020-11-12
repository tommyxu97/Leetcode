package Algorithm;

public class Q922 {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) return A;
        int index = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 != 0) {
                while (A[index] % 2 == 1) {
                    index += 2;
                }
                swap(A, i, index);
            }
        }
        return A;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
