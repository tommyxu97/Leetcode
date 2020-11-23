package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        // 按照气球有边界排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int last = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (last < points[i][0]) {
                last = points[i][1];
                count++;
            }
        }
        return count;
    }
}
