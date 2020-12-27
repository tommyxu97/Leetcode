package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q227 {
    public static void main(String[] args) {
        Q227 q227 = new Q227();
        System.out.println(q227.calculate(" 3/2 "));
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char operation = '+';
        for (int i = 0; i < chars.length; i++) {
            if (isDigit(chars[i])) {
                num = num * 10 + (chars[i] - '0');
            }
            if (isOperator(chars[i]) || i == chars.length - 1) {
                if (operation == '+') stack.push(num);
                else if (operation == '-') stack.push(-num);
                else if (operation == '*') stack.push(stack.pop() * num);
                else stack.push(stack.pop() / num);
                operation = chars[i];
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
