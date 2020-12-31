package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval: intervals) {
            if (interval[0] >= end) {
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
