public class Offer14_1 {

    public static void main(String[] args) {
        System.out.println(new Offer14_1().cuttingRope(10));
        System.out.println(new Offer14_1().cuttingRope2(10));
    }

    // DP
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max((i-j) * j, dp[i-j] * j));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    // 贪心/数学推导
    public int cuttingRope2(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int a = n / 3; int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

}
