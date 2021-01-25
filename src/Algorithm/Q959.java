package Algorithm;

public class Q959 {
    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) return 0;
        UnionFind unionFind = new UnionFind(grid.length * grid.length * 4);
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int index = 4 * (grid.length * i + j);
                if (chars[j] == ' ') {
                    unionFind.union(index, index + 1);
                    unionFind.union(index, index + 2);
                    unionFind.union(index, index + 3);
                } else if (chars[j] == '/') {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                }
                if (i > 0) {
                    unionFind.union(index, index - 4 * grid.length + 2);
                }
                if (j > 0) {
                    unionFind.union(index + 1, index - 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < unionFind.size(); i++) {
            if (i == unionFind.find(i)) res++;
        }
        return res;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        public int size() {
            return parent.length;
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
                return true;
            }
        }
    }
}
