package Algorithm;

import java.util.Arrays;

public class Q834 {
    // 直接DFS遍历每个节点会超内存
    private int[][] matrix;
    private boolean[] visited;
    private int[][] path;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (edges.length == 0) return new int[] {0};
        matrix = new int[N][N];
        path = new int[N][N];
        for (int[] temp: matrix) {
            Arrays.fill(temp, -1);
        }
        for (int[] edge: edges) {
            this.matrix[edge[0]][edge[1]] = 1;
            this.matrix[edge[1]][edge[0]] = 1;
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i, N, 0);
        }
        int[] res = new int[N];
        int index = 0;
        for (int[] temp: path) {
            for (int num: temp) res[index] += num;
            index++;
        }
        return res;
    }

    private void dfs(int startNode, int curNode, int N, int deep) {
        visited[curNode] = true;
        path[startNode][curNode] = deep;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && matrix[curNode][i] == 1) dfs(startNode, i, N, deep + 1);
        }
    }
}
