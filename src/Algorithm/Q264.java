package Algorithm;

public class Q264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[p2] * 2, num2 = dp[p3] * 3, num3 = dp[p5] * 5;
            int min = Math.min(Math.min(num1, num2), num3);
            dp[i] = min;
            if (min == num1) {
                p2++;
            }
            if (min == num2) {
                p3++;
            }
            if (min == num3) {
                p5++;
            }
        }
        return dp[n];
    }
}
