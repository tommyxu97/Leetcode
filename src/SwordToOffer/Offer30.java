package SwordToOffer;

public class Offer30 {

    public static void main(String[] args) {

    }

}

// 链表实现
/**
 * Your SwordToOffer.MinStack object will be instantiated and called as such:
 * SwordToOffer.MinStack obj = new SwordToOffer.MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
class MinStack {

    private Node head;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x);
            head.min = x;
        } else {
            Node temp = new Node(x);
            temp.min = Math.min(x, head.min);
            temp.next = head;
            head = temp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }
}

class Node {
    int val, min;
    Node next = null;
    public Node(int val) { this.val = val; }
}
