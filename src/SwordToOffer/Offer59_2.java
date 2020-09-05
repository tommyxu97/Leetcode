package SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer59_2 {


}

/**
 * Your SwordToOffer.MaxQueue object will be instantiated and called as such:
 * SwordToOffer.MaxQueue obj = new SwordToOffer.MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.peekFirst() != null? deque.peekFirst(): -1;
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int res = queue.poll();
        if (res == deque.peekFirst()) deque.pollFirst();
        return res;
    }
}