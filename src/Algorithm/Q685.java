package Algorithm;

public class Q685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] inDegree = new int[len + 1];
        // 初始化入度数组
        for (int[] edge: edges) {
            inDegree[edge[1]]++;
        }
        // 先判断构成入度为2的边
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        // 判断构成入度为1的边
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        return new int[2];
    }

    // 判断去掉一条边后，图中是否形成环
    private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == removeEdgeIndex) {
                continue;
            }
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                return true;
            }
        }
        return false;
    }

    // 并查集
    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
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
            parent[rootX] = rootY;
            return true;
        }
    }
}
