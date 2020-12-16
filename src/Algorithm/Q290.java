package Algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q290 {
    public boolean wordPattern(String pattern, String s) {
        List<String> words = Arrays.asList(s.split(" "));
        char[] chars = pattern.toCharArray();
        if (chars.length != words.size()) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            String word = words.get(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) return false;
            } else {
                if (set.contains(word)) return false;
                else {
                    map.put(c, word);
                    set.add(word);
                }
            }
        }
        return true;
    }
}
