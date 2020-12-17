package Algorithm;

public class Q714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }
}
