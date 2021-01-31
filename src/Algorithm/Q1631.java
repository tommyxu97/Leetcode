package Algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1631 {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.offer(new int[] {0, 0, 0});

        int[] dist = new int[m * n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] visited = new boolean[m * n];

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int x = edge[0], y = edge[1], d = edge[2];
            int id = x * n + y;
            if (visited[id]) continue;
            if (x == m - 1 && y == n - 1) break;
            visited[id] = true;
            // 更新四个方向节点的最短路径
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                        Math.max(d, Math.abs(heights[x][y] - heights[nx][ny])) < dist[nx * n + ny]) {
                    dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                    queue.offer(new int[] {nx, ny, dist[nx * n + ny]});
                }
            }
        }
        return dist[m * n - 1];
    }
}
