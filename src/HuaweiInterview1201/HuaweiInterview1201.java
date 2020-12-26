package HuaweiInterview1201;

import java.util.LinkedList;
import java.util.List;

public class HuaweiInterview1201 {
    public static void main(String[] args) {
        HuaweiInterview1201 huaweiInterview1201 = new HuaweiInterview1201();
        System.out.println(huaweiInterview1201.isPerfectNumber(6));
    }

    public boolean isPerfectNumber(int num) {
        if (num == 1) return true;
        List<Integer> factor = new LinkedList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) factor.add(i);
        }
        int res = 0;
        for (int i = 0; i < factor.size(); i++) {
            res += factor.get(i);
        }
        return res == num;
    }

    private boolean[][] visited;

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        visited[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
            dfs(grid, i, j + 1);
        }
    }
}
