package Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> countSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (countSet.contains(entry.getValue())) return false;
            else countSet.add(entry.getValue());
        }
        return true;
    }
}
