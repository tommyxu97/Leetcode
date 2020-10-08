package ByteDance.DynamicAndGreedy;

public class Q2 {
    // 与主题库Q122相同
    // 贪心算法
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) res += prices[i + 1] - prices[i];
        }
        return res;
    }
}
