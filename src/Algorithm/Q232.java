package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q232 {

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
    private Deque<Integer> stackA;
    private Deque<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stackB.isEmpty()) {
            return stackB.pop();
        } else if (!stackA.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        } else {
            return -1;
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!stackB.isEmpty()) {
            return stackB.peek();
        } else if (!stackA.isEmpty()) {
            return stackA.peekLast();
        } else {
            return -1;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}