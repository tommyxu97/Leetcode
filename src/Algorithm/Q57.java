package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> res = new LinkedList<>();
        int index = 0;
        while (index < len && intervals[index][1] < newInterval[0]) {
            res.add(intervals[index]);
            index++;
        }
        while (index < len && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        res.add(newInterval);
        while (index < len) {
            res.add(intervals[index]);
            index++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
