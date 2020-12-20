package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        int[] counts = new int[26];
        Deque<Character> stack = new LinkedList<>();
        boolean[] inStack = new boolean[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c: s.toCharArray()) {
            if (!inStack[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 0) {
                    inStack[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                inStack[c - 'a'] = true;
            }
            counts[c - 'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: stack) stringBuilder.append(c);
        return stringBuilder.reverse().toString();
    }
}
