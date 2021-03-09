package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q1047 {
    // 31ms
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (char c: S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }

    // 12ms
    public String removeDuplicates2(String S) {
        StringBuilder builder = new StringBuilder(S);
        int index = 1;
        while (index < builder.length()) {
            while (index - 1 >= 0 && index < builder.length() && builder.charAt(index) == builder.charAt(index - 1)) {
                builder.delete(index - 1, index + 1);
                index--;
            }
            index++;
        }
        return builder.toString();
    }
}
