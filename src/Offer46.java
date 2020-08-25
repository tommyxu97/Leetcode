public class Offer46 {

    public static void main(String[] args) {
        Offer46 offer46 = new Offer46();
        System.out.println(offer46.translateNum(12258));
    }

    // DP，类似于青蛙跳台阶，本质斐波那契数列问题
    public int translateNum(int num) {
        String numString = String.valueOf(num);
        int[] dp = new int[numString.length()];
        dp[0] = 1; if (numString.length() == 1) return dp[0];
        dp[1] = Integer.parseInt(numString.substring(0, 2)) <= 25? 2: 1;
        for (int i = 2; i < numString.length(); i++) {
            dp[i] = Integer.parseInt(numString.substring(i - 1, i + 1)) <= 25 && numString.charAt(i - 1) != '0' // 前一位是0不算
                    ? dp[i - 1] + dp[i - 2]: dp[i - 1];
        }
        return dp[numString.length() - 1];
    }
}
