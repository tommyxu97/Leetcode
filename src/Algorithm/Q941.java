package Algorithm;

public class Q941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int index = 1, peak = 0;
        while (index < A.length && A[index] > A[index - 1]) {
            peak = index;
            index++;
        }
        while (index < A.length && A[index] < A[index - 1]) {
            index++;
        }
        return index == A.length && peak != 0 && peak != A.length - 1;
    }
}
