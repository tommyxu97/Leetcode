package Algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q20 {
    // 36ms
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.equals("");
    }

    // 2ms
    private final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')'); put('{', '}'); put('[', ']');
    }};
    public boolean isValid2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('?');
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) stack.push(c);
            else if (map.getOrDefault(stack.peek(), '?') != c) return false;
            else stack.pop();
        }
        return stack.size() == 1;
    }
}
