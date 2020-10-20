package Algorithm;

public class Q5 {
    // 二维DP
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int begin = 0, length = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 填完dp[i][j]后判断是否是回文子串，并判断是否需要记录
                if (dp[i][j] && j - i + 1 > length) {
                    length = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + length);
    }
}
