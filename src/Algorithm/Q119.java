package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        int temp = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j > 0; j--) {
                dp[j] += dp[j - 1];
            }
        }
        List<Integer> res = new ArrayList<>(rowIndex);
        for (int num: dp) res.add(num);
        return res;
    }
}
