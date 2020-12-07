package Algorithm;

public class Q861 {
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0) return 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] == 0? 1: 0;
                }
            }
        }
        for (int j = 1; j < A[0].length; j++) {
            int zeroCount = 0, oneCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) zeroCount++;
                else oneCount++;
            }
            if (zeroCount > oneCount) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = A[i][j] == 0? 1: 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) res += Math.pow(2, A[0].length - 1 - j);
            }
        }
        return res;
    }
}
