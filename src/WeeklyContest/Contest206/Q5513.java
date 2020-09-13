package WeeklyContest.Contest206;

import java.util.Arrays;

public class Q5513 {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] used = new boolean[n];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            int point = -1;
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                if (point == -1 || dist[j] < dist[point]) {
                    point = j;
                }
            }
            used[point] = true;
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                dist[j] = Math.min(dist[j], getDistance(points[point], points[j]));
            }
        }
        return Arrays.stream(dist).sum();
    }

    public int getDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
