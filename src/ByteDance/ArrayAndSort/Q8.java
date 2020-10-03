package ByteDance.ArrayAndSort;

import java.util.HashSet;
import java.util.Set;

public class Q8 {
    // 与主题库Q547相同
    // 并查集
    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M[0].length; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M.length; i++) {
            set.add(unionFind.find(i));
        }
        return set.size();
    }

    static class UnionFind {
        private int[] parent;

        UnionFind(int initSize) {
            parent = new int[initSize];
            for (int i = 0; i < initSize; i++) parent[i] = i;
        }

        int find(int element) {
            if (element != parent[element]) {
                return find(parent[element]);
            } else return element;
        }

        void union(int element1, int element2) {
            int firstRoot = find(element1);
            int secondRoot = find(element2);
            if (firstRoot == secondRoot) return;
            parent[firstRoot] = secondRoot;
        }

        boolean isConnected(int element1, int element2) {
            return find(element1) == find(element2);
        }
    }

    // DFS
    private boolean[] visited;
    private int group = 0;

    public int findCircleNum2(int[][] M) {
        visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) group++;
            dfs(M, i);
        }
        return group;
    }

    private void dfs(int[][] M, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j);
            }
        }
    }
}
