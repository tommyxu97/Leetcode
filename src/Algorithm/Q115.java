package Algorithm;

public class Q115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        if (s.equals(t)) return 1;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = t.length() - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
