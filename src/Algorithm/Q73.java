package Algorithm;

public class Q73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix.length; k++) if (k != i && matrix[k][j] != 0) matrix[k][j] = 999;
                    for (int k = 0; k < matrix[0].length; k++) if (k != j && matrix[i][k] != 0) matrix[i][k] = 999;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 999) matrix[i][j] = 0;
            }
        }
    }
}
