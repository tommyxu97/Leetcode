package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval: intervals) {
            if (index == -1 || res[index][1] < interval[0]) {
                index++;
                res[index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}
