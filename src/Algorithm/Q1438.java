package Algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q1438 {
    // 184ms
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

    // 41ms
    public int longestSubarray2(int[] nums, int limit) {
        int left = 0, right = 0;
        int len = nums.length;
        int max = 0;
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        while (right < len) {
            while (!minQueue.isEmpty() && nums[right] < nums[minQueue.peekLast()]) {
                minQueue.pollLast();
            }
            minQueue.addLast(right);
            while (!maxQueue.isEmpty() && nums[right] > nums[maxQueue.peekLast()]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(right);
            while (!minQueue.isEmpty() && !maxQueue.isEmpty() && nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit) {
                if (minQueue.peek() <= left) minQueue.poll();
                if (maxQueue.peek() <= left) maxQueue.poll();
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
