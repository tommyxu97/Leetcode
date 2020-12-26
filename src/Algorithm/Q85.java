package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q85 {
    // 利用Q84的思路，遍历每一行的时候看做柱状图
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int curIndex = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * newHeights[curIndex]);
            }
            stack.push(i);
        }
        return res;
    }
}
