package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q331 {
    public static void main(String[] args) {
        System.out.println(new Q331().isValidSerialization("9,#,92,#,#"));
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;
        Deque<String> stack = new LinkedList<>();
        String[] strings = preorder.split(",");
        for (String string: strings) {
            if (string.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty() || stack.peek().equals("#")) return false;
                    stack.pop();
                }
                stack.push("#");
            } else {
                stack.push(string);
            }
        }
        if (stack.size() != 1) return false;
        return stack.peek().equals("#");
    }
}
