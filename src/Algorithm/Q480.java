package Algorithm;

import java.util.Arrays;

public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) return new double[0];
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            int[] window = new int[k];
            if (i + k - i >= 0) System.arraycopy(nums, i, window, 0, i + k - i);
            Arrays.sort(window);
            res[i] = k % 2 == 1? window[k / 2]: ((double) window[k / 2 - 1] / 2 + (double) window[k / 2] / 2);
        }
        return res;
    }
}
