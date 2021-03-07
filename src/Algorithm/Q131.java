package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[j] == chars[i] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        List<List<String>> res = new LinkedList<>();
        recur(res, new LinkedList<>(), s, 0, dp);
        return res;
    }

    private void recur(List<List<String>> res, List<String> temp, String s, int index, boolean[][] dp) {
        if (index == s.length()) {
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                recur(res, temp, s, i + 1, dp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
