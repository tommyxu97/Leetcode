package Algorithm;

public class Q463 {
    private int res = 0;
    private boolean[][] visited;

    // DFS 11ms
    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)  {
                    recur(grid, i, j); return res;
                }
            }
        }
        return res;
    }

    private void recur(int[][] grid, int i, int j) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            recur(grid, i - 1, j);
        } else {
            res++;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            recur(grid, i + 1, j);
        } else {
            res++;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            recur(grid, i, j - 1);
        } else {
            res++;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            recur(grid, i, j + 1);
        } else {
            res++;
        }
    }

    // 遍历 8ms
    public int islandPerimeter2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) res -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) res -= 2;
                }
            }
        }
        return res;
    }
}
