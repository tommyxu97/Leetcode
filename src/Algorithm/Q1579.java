package Algorithm;

public class Q1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        int res = 0;
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        for (int[] edge: edges) {
            int type = edge[0], x = edge[1] - 1, y = edge[2] - 1;
            if (type == 3) {
                if (!alice.isConnected(x, y)) {
                    alice.union(x, y);
                    bob.union(x, y);
                } else res++;
            }
        }
        for (int[] edge: edges) {
            int type = edge[0], x = edge[1] - 1, y = edge[2] - 1;
            if (type == 2) {
                if (!bob.isConnected(x, y)) {
                    bob.union(x, y);
                } else res++;
            } else if (type == 1) {
                if (!alice.isConnected(x, y)) {
                    alice.union(x, y);
                } else res++;
            }
        }
        return alice.numOfCluster == 1 && bob.numOfCluster == 1? res: -1;
    }

    class UnionFind {
        private int[] parent;
        private int numOfCluster;

        public UnionFind(int size) {
            parent = new int[size];
            numOfCluster = size;
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        public int numOfCluster() {
            return numOfCluster;
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
            else {
                parent[rootX] = rootY;
                numOfCluster--;
                return true;
            }
        }
    }
}
