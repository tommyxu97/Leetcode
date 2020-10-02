package Algorithm;

import java.util.PriorityQueue;

public class Q215 {
    // 小顶堆
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
