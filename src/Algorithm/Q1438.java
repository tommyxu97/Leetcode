package Algorithm;

import java.util.PriorityQueue;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        int len = nums.length;
        int max = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        while (right < len) {
            minHeap.add(nums[right]);
            maxHeap.add(nums[right]);
            while (maxHeap.peek() - minHeap.peek() > limit) {
                minHeap.remove(nums[left]);
                maxHeap.remove(nums[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
