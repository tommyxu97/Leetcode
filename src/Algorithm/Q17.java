package Algorithm;

import java.util.*;

public class Q17 {
    // 循环, 6ms
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new LinkedList<>();
        String[] strings = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        for (char c: digits.toCharArray()) {
            if (c == '0' || c == '1') return new LinkedList<>();
            int index = c - '0';
            if (queue.isEmpty()) {
                for (char temp: strings[index].toCharArray()) {
                    queue.add(String.valueOf(temp));
                }
            } else {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String tempString = queue.poll();
                    for (char temp: strings[index].toCharArray()) {
                        queue.add(tempString + temp);
                    }
                }
            }
        }
        return new LinkedList<>(queue);
    }

    // DFS, 1ms
    private List<String> res = new LinkedList<>();

    public List<String> letterCombinations2(String digits) {
        if(digits == null || digits.length() == 0) return new LinkedList<>();
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        recur(map, digits, 0, new StringBuilder());
        return res;
    }

    public void recur(Map<Character, String> map, String digits, int index, StringBuilder builder) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            builder.append(letters.charAt(i));
            recur(map, digits, index + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
