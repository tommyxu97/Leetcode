import java.util.Stack;

public class Offer31 {

    public static void main(String[] args) {
        Offer31 offer31 = new Offer31();
        System.out.println(offer31.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(offer31.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    // 使用一个栈模拟操作
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int push: pushed) {
            stack.push(push);
            while (index < popped.length && !stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop(); index++;
            }
        }
        return index == popped.length;
    }
}
