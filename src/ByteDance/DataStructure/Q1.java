package ByteDance.DataStructure;

import java.util.Stack;

public class Q1 {

}

class MinStack {

    private final Stack<Integer> stackA;
    private final Stack<Integer> stackB;

    /** initialize your data structure here. */
    public MinStack() {
        // 建议使用Deque代替Stack类
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.add(x);
        if (stackB.isEmpty() || stackB.peek() >= x) {
            stackB.add(x);
        }
    }

    public void pop() {
        if (stackA.pop().equals(stackB.peek())) {
            stackB.pop();
        }

    }

    public int top() {
        return stackA.peek();
    }

    public int getMin() {
        return stackB.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */