package Algorithm;

import java.util.PriorityQueue;

public class Q703 {
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        for (int num: nums) add(num);
    }

    public int add(int val) {
        if (minHeap.size() < size) {
            minHeap.add(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
