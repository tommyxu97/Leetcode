package Algorithm;

public class Q566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) return nums;
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c) return nums;
        int x = 0, y = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[x][y];
                if (y + 1 == col) {
                    x += 1; y = 0;
                } else {
                    y += 1;
                }
            }
        }
        return res;
    }
}
