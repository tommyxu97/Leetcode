package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.addLast(i);
            if (deque.peek() <= i - k) deque.poll();
            if (i >= k - 1) res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }
}
