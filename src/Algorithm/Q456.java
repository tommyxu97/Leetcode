package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q456 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
