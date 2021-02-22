package Algorithm;

public class Q766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int start = 0; start < row; start++) {
            int num = matrix[start][0];
            int i = start + 1, j = 1;
            while (i < row && j < col) {
                if (matrix[i][j] != num) return false;
                i++; j++;
            }
        }
        for (int start = 1; start < col; start++) {
            int num = matrix[0][start];
            int i = 1, j = start + 1;
            while (i < row && j < col) {
                if (matrix[i][j] != num) return false;
                i++; j++;
            }
        }
        return true;
    }
}
