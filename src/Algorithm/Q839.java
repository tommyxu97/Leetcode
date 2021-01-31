package Algorithm;

public class Q839 {
    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) return 0;
        UnionFind unionFind = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) unionFind.union(i, j);
            }
        }
        return unionFind.cluster;
    }

    private boolean isSimilar(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int index = -1, difference = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (difference == 0) {
                    index = i;
                } else if (difference == 1) {
                    if (str1.charAt(index) != str2.charAt(i)) return false;
                }
                difference++;
            }
        }
        // 字符串相等也是相似
        return difference == 0 || difference == 2;
    }

    class UnionFind {
        int[] parent;
        int cluster;

        public UnionFind(int size) {
            parent = new int[size];
            cluster = size;
            for (int i = 0; i < size; i++) parent[i] = i;
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
            if (rootX == rootY) return false;
            else {
                parent[rootX] = rootY;
                cluster--;
                return true;
            }
        }
    }
}
