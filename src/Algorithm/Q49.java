package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (!map.containsKey(temp)) map.put(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
