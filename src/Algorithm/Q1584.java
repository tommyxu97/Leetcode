package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1584 {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 0;
        PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new int[] {i, j, distance(points[i], points[j])});
            }
        }
        int numOfEdges = 0;
        UnionFind unionFind = new UnionFind(points.length);
        while (!edges.isEmpty() && numOfEdges < points.length - 1) {
            int[] edge = edges.poll();
            if (unionFind.find(edge[0]) != unionFind.find(edge[1])) {
                unionFind.union(edge[0], edge[1]);
                res += edge[2];
                numOfEdges++;
            }
        }
        return res;
    }

    private int distance(int[] point1, int[] point2) {
        return Math.abs(point2[1] - point1[1]) + Math.abs(point2[0] - point1[0]);
    }

    private class UnionFind {
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
