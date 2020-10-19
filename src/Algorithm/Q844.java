package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q844 {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> dequeA = new LinkedList<>();
        Deque<Character> dequeB = new LinkedList<>();
        for (char c: S.toCharArray()) {
            if (c == '#') {
                if (!dequeA.isEmpty()) dequeA.pollLast();
            } else {
                dequeA.addLast(c);
            }
        }
        for (char c: T.toCharArray()) {
            if (c == '#') {
                if (!dequeB.isEmpty()) dequeB.pollLast();
            } else {
                dequeB.addLast(c);
            }
        }
        return dequeA.equals(dequeB);
    }
}
