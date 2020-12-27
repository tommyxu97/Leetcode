package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q224 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char operator = '+';
        for (int i = 0; i < chars.length; i++) {
            if (isDigit(chars[i])) num = num * 10 + (chars[i] - '0');
            if (chars[i] == '(') {
                int right = pairIndex(s, i + 1);
                num = calculate(s.substring(i + 1, right));
                i = right;
            }
            if (isOperator(chars[i]) || i == chars.length - 1) {
                if (operator == '+') stack.push(num);
                else stack.push(-num);
                operator = chars[i];
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
        return c == '+' || c == '-';
    }

    private int pairIndex(String str, int leftIndex) {
        int count = 0;
        for (int i = leftIndex + 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (count == 0) return i;
                else count--;
            } else if (str.charAt(i) == '(') {
                count++;
            }
        }
        return -1;
    }
}
