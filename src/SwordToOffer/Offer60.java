package SwordToOffer;

public class Offer60 {

    // DP
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        // 记录点数和对应的次数
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n * 6; j++) {
                for (int k = 1; k <= 6 && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double totalNum = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) { // n次色子最小的点数和是n
            res[i - n] = ((double) dp[n][i]) / totalNum;
        }
        return res;
    }
}
