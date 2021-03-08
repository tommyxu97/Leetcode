package Algorithm;

import java.util.Arrays;

public class Q132 {
    public int minCut(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = true;
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < len; left++) {
                if (chars[left] == chars[right] && (right - left < 3 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[len - 1];
    }
}
