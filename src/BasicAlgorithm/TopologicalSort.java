package BasicAlgorithm;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class TopologicalSort {
    public List<Integer> topologicalSort(int n, int[][] adjacentMatrix) {
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int[] parent: adjacentMatrix) {
            for (int child: parent) {
                inDegree[child]++;
            }
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) deque.offer(i);
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            res.add(cur);
            for (int child: adjacentMatrix[cur]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
            }
        }

        ReentrantLock lock = new ReentrantLock();
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;

        return res.size() == n? res: new ArrayList<>();
    }
}
