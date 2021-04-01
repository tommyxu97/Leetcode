package Algorithm;

public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) row += 1;
            else col -= 1;
        }
        return false;
    }
}
