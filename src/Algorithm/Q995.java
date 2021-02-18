package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q995 {
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (deque.size() > 0 && i >= deque.peekFirst() + K) {
                deque.removeFirst();
            }
            if (deque.size() % 2 == A[i]) {
                if (i + K > A.length) return -1;
                deque.addLast(i);
                res++;
            }
        }
        return res;
    }
}
