package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) priorityQueue.add(stone);
        while (priorityQueue.size() >= 2) {
            int stoneA = priorityQueue.poll();
            int stoneB = priorityQueue.poll();
            int delta = Math.abs(stoneA - stoneB);
            if (delta != 0) priorityQueue.add(delta);
        }
        return priorityQueue.isEmpty()? 0: priorityQueue.peek();
    }
}
