package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Q402 {
    public static void main(String[] args) {
        Q402 q402 = new Q402();
        q402.removeKdigits("123454321", 4);
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        StringBuilder stringBuilder = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int index = 0;
            // 遍历找到第一个比后面大的数
            for (int j = 1; j < stringBuilder.length() && stringBuilder.charAt(j - 1) <= stringBuilder.charAt(j); j++) {
                index = j;
            }
            stringBuilder.deleteCharAt(index);
            while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }

    // 单调栈
    public String removeKdigits2(String num, int k) {
        if (num == null || num.length() < k) return null;
        Deque<Character> deque = new LinkedList<>();
        int remove = k;
        for (char c: num.toCharArray()) {
            while (!deque.isEmpty() && remove > 0 && deque.peekLast() > c) {
                deque.pollLast();
                remove--;
            }
            deque.addLast(c);
        }
        int remain = num.length() - k;
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
            remain--;
        }
        while (remain > 0) {
            builder.append(deque.pollFirst());
            remain--;
        }
        return builder.length() == 0? "0": builder.toString();
    }
}
