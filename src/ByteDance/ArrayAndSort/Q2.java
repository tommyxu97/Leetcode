package ByteDance.ArrayAndSort;

public class Q2 {

    // 与主题库Q695相同
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == 0 || visited[row][col]) return 0;
        visited[row][col] = true;
        return dfs(grid, row - 1, col) + dfs(grid, row + 1, col) + dfs(grid, row, col - 1) + dfs(grid, row, col + 1) + 1;
    }
}
