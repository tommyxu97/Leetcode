package Algorithm;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new LinkedList<>();
        if (accounts == null || accounts.size() == 0) return res;
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int size = 0;
        for (List<String> account: accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, size++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind unionFind = new UnionFind(size);
        for (List<String> account: accounts) {
            for (int i = 2; i < account.size(); i++) {
                unionFind.union(emailToId.get(account.get(i - 1)), emailToId.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> groupedEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToId.entrySet()) {
            String email = entry.getKey();
            Integer id = entry.getValue();
            int parent = unionFind.find(id);
            if (!groupedEmails.containsKey(parent)) groupedEmails.put(parent, new LinkedList<>());
            groupedEmails.get(parent).add(email);
        }
        for (List<String> group: groupedEmails.values()) {
            Collections.sort(group);
            group.add(0, emailToName.get(group.get(0)));
            res.add(group);
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int num) {
            parent = new int[num];
            for (int i = 0; i < parent.length; i++) parent[i] = i;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            } else {
                parent[rootX] = rootY;
                return true;
            }
        }
    }
}

