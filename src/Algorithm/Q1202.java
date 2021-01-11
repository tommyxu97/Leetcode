package Algorithm;

import java.util.*;

public class Q1202 {
    public static void main(String[] args) {
        Q1202 q1202 = new Q1202();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>() {{
            add(new ArrayList<>() {{add(0); add(2);}});
            add(new ArrayList<>() {{add(1); add(2);}});
            add(new ArrayList<>() {{add(0); add(2);}});
        }};
        q1202.smallestStringWithSwaps(s, pairs);
    }

    private int[] parent;

    // 使用并查集
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.size() == 0) return s;
        parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (List<Integer> pair: pairs) union(pair.get(0), pair.get(1));
        char[] chars = new char[s.length()];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int parent = find(i);
            if (map.containsKey(parent)) map.get(parent).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(parent, list);
            }
        }
        for (List<Integer> list: map.values()) {
            List<Character> tempChars = new ArrayList<>();
            for (int index: list) tempChars.add(s.charAt(index));
            Collections.sort(tempChars);
            for (int i = 0; i < tempChars.size(); i++) {
                chars[list.get(i)] = tempChars.get(i);
            }
        }
        return String.valueOf(chars);
    }

    private void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if (root1 != root2) parent[root1] = root2;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
