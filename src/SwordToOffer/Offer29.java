package SwordToOffer;

import java.util.Arrays;

public class Offer29 {

    public static void main(String[] args) {
        int[][] test = new int[][] {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9, 10}
        };
        System.out.println(Arrays.toString(new Offer29().spiralOrder(test)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int row = matrix.length, column = matrix[0].length;
        int[] res = new int[row * column];

        int index = 0, left = 0, right = column - 1, top = 0, bottom = row - 1;
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) res[index++] = matrix[top][i];
            if (++top > bottom) break;
            // 从上到下
            for (int i = top; i <= bottom; i++) res[index++] = matrix[i][right];
            if (--right < left) break;
            // 从右到左
            for (int i = right; i >= left; i--) res[index++] = matrix[bottom][i];
            if (--bottom < top) break;
            // 从下到上
            for (int i = bottom; i >= top; i--) res[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }
}
