package Algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sChars[i])) {
                if (map.get(sChars[i]) != tChars[i]) return false;
            } else {
                if (set.contains(tChars[i])) return false;
                else {
                    map.put(sChars[i], tChars[i]);
                    set.add(tChars[i]);
                }
            }
        }
        return true;
    }
}
