package Algorithm;

public class Q832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (col + 1) / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][col - 1 - j] == 1? 0: 1;
                if (j != col - j - 1) A[i][col - 1 - j] = temp == 1? 0: 1;
            }
        }
        return A;
    }
}
