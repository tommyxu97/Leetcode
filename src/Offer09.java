import java.util.Stack;

public class Offer09 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(12);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(10);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

}


class CQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (!stackB.isEmpty()) {
            return stackB.pop();
        } else if (!stackA.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
        return -1;
    }
}
