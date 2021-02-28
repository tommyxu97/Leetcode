package Algorithm;

public class Q896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        int start = 0, flag = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == 0) continue;
            flag = A[i] - A[i - 1];
            start = i + 1;
            break;
        }
        if (start == 0) return true;
        for (int i = start; i < A.length; i++) {
            if ((A[i] - A[i - 1]) * flag < 0) return false;
        }
        return true;
    }
}
