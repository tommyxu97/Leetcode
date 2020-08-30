import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Offer59_1 {

    public static void main(String[] args) {
        Offer59_1 offer59_1 = new Offer59_1();
        System.out.println(Arrays.toString(offer59_1.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        // Expected: [3, 3, 5, 5, 6, 7]
    }

    // 暴力法，时间复杂度O(nk)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int start = 0, end = k - 1;
        while (end < nums.length) {
            int max = nums[start];
            for (int i = start; i <= end; i++) {
                max = Math.max(nums[i], max);
            }
            res[start] = max;
            start++; end++;
        }
        return res;
    }

    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.peekFirst()) deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
