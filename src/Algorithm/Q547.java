package Algorithm;

public class Q547 {
    private boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int index) {
        visited[index] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (i == index) continue;
            if (isConnected[i][index] == 1 && !visited[i]) {
                dfs(isConnected, i);
            }
        }
    }
}
