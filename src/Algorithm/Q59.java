package Algorithm;

public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int j = left; j <= right; j++) {
                res[top][j] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            for (int j = right; j >= left && top <= bottom; j--) {
                res[bottom][j] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
