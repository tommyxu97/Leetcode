package Algorithm;

public class Q1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections == null || connections.length < n - 1) return -1;
        int res = 0;
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection: connections) {
            unionFind.union(connection[0], connection[1]);
        }
        for (int i = 0; i < n; i++) {
            if (i == unionFind.find(i)) res++;
        }
        return res - 1;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            else parent[rootX] = rootY;
            return true;
        }
    }
}
