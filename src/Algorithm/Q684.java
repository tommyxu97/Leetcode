package Algorithm;

public class Q684 {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        if (edges == null || edges.length == 0) return res;
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int[] edge: edges) {
            if (!union(edge[0], edge[1])) {
                res[0] = edge[0]; res[1] = edge[1];
            }
        }
        return res;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            return true;
        } else {
            return false;
        }
    }
}
