package Algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q1030 {
    // 31ms
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>(R * C);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res.add(new int[] {i, j});
            }
        }
        res.sort(Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
        return res.toArray(new int[res.size()][]);
    }
}
