package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
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
