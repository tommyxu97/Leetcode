package Algorithm;

public class Q32 {
    // 重点为搞清楚dp的转移关系，在chars[i]==')'的时候分类处理
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i >= 2? dp[i - 2]: 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i -  1] - 2 >= 0? dp[i - dp[i - 1] - 2]: 0) + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
