package Algorithm;

import java.util.Arrays;

public class Q1024 {
    // 动态规划,2ms
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i <= T; i++) {
            for (int[] clip: clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE / 2? -1: dp[T];
    }

    // 贪心,0ms
    public int videoStitching2(int[][] clips, int T) {
        int[] maxRight = new int[T];
        int res = 0, last = 0, pre = 0;
        for (int[] clip: clips) {
            if (clip[0] < T) {
                maxRight[clip[0]] = Math.max(maxRight[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxRight[i]);
            if (i == last) return -1;
            if (i == pre) {
                res++;
                pre = last;
            }
        }
        return res;
    }
}
