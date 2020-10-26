package Algorithm;

public class Q845 {
    // 3ms
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            left[i] = A[i] > A[i - 1]? left[i - 1] + 1: 0;
        }
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = A[i] > A[i + 1]? right[i + 1] + 1: 0;
        }
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (left[i] != 0 && right[i] != 0) {
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }

    // 2ms
    public int longestMountain2(int[] A) {
        if (A == null || A.length < 3) return 0;
        int res = 0, index = 1;
        while (index < A.length) {
            int increase = 0, decrease = 0;
            while (index < A.length && A[index] > A[index - 1]) {
                increase++; index++;
            }
            while (index < A.length && A[index] < A[index - 1]) {
                decrease++; index++;
            }
            if (increase > 0 && decrease > 0) {
                res = Math.max(res, increase + decrease + 1);
            }
            while (index < A.length && A[index] == A[index -1]) index++;
        }
        return res;
    }
}
