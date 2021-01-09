package Algorithm;

public class Q123 {
    // 相关题目Q188，dp[i]表示第i交易，[0]表示该时刻买入股票，[1]表示该时刻卖出股票
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[2][2];
        dp[0][0] = Integer.MIN_VALUE;
        dp[1][0] = Integer.MIN_VALUE;
        for (int p: prices) {
            dp[0][0] = Math.max(dp[0][0], -p);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);
            dp[1][0] = Math.max(dp[1][0], dp[0][1] - p);
            dp[1][1] = Math.max(dp[1][1], dp[1][0] + p);
        }
        return dp[1][1];
    }
}
