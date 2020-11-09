package Algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Q973 {
    // 32ms
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOf(points, K);
    }

    // 快速选择算法, 4ms
    public int[][] kClosest2(int[][] points, int K) {
        quick_select(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quick_select(int[][] point, int left, int right, int K) {
        if (left >= right) return;
        int i = left, j = right;
        int pivot = getDistance(point[left]);
        int[] pivotPoint = point[left];
        while (i < j) {
            while (i < j && getDistance(point[j]) >= pivot) j--;
            point[i] = point[j];
            while (i < j && getDistance(point[i]) < pivot) i++;
            point[j] = point[i];
        }
        point[i] = pivotPoint;
        if (i == K) return;
        if (i < K) quick_select(point, i + 1, point.length - 1, K);
        else quick_select(point, left, i - 1, K);
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
