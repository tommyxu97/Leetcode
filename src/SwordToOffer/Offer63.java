package SwordToOffer;

public class Offer63 {

    // DP
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(prices[i] - prices[i - 1] + dp[i - 1], 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
