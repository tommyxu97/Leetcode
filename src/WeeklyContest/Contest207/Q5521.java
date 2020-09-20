package WeeklyContest.Contest207;

public class Q5521 {

    private long res = -1;
    private long temp = 1;
    private boolean[][] visited;

    public int maxProductPath(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        if (grid[0][0] == 0 || grid[grid.length - 1][grid[0].length - 1] == 0) return 0;
        dfs(grid, 0, 0);
        int MOD = 1000000007;
        return (int) (res % MOD);
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            temp *= grid[grid.length - 1][grid[0].length - 1];
            if (temp > 0) res = Math.max(res, temp);
            temp /= grid[grid.length - 1][grid[0].length - 1];
            return;
        }
        if (grid[i][j] == 0) {
            visited[i][j] = true;
            res = Math.max(0, res);
            return;
        }
        temp *= grid[i][j];
        visited[i][j] = true;
        if (i + 1 < grid.length && !visited[i + 1][j]) dfs(grid, i + 1, j);
        if (j + 1 < grid[0].length && !visited[i][j + 1]) dfs(grid, i, j + 1);
        temp /= grid[i][j];
        visited[i][j] = false;
    }
}
