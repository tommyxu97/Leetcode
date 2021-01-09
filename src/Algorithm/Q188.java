package Algorithm;

public class Q188 {
    // 相关题目Q123，注意初始条件判断，k==0时可以直接返回
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k == 0) return 0;
        if (k >= prices.length / 2) return greedyProfit(prices);
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int p: prices) {
            dp[0][0] = Math.max(dp[0][0], -p);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);
            for (int i = 1; i < k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] -  p);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + p);
            }
        }
        return dp[k - 1][1];
    }

    private int greedyProfit(int[] price) {
        int res = 0;
        for (int i = 1; i < price.length; i++) {
            res += Math.max(price[i] - price[i - 1], 0);
        }
        return res;
    }
}
