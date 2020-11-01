package Algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    // 9ms
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (!dp[j]) {
                    // 只有dp[j] == false的时候才需要更新
                    dp[j] = dp[i] && wordSet.contains(s.substring(i, j));
                }
            }
        }
        return dp[s.length()];
    }
}
