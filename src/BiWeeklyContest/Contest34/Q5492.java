package BiWeeklyContest.Contest34;

import java.util.ArrayList;
import java.util.List;

public class Q5492 {

    // https://leetcode-cn.com/contest/biweekly-contest-34/
    // https://leetcode-cn.com/problems/number-of-ways-to-split-a-string/

    public int numWays(String s) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') index.add(i);
        }
        if (index.size() % 3 != 0) return 0;
        int temp = index.size() / 3;
        if (temp == 0) return getN(s.length());
        long firstEnd = index.get(temp - 1), secondStart = index.get(temp),
                secondEnd = index.get(temp * 2 - 1), thirdStart = index.get(temp * 2);
        long res = (secondStart - firstEnd) * (thirdStart - secondEnd);
        return (int) (res % 1000000007);
    }

    public int getN(int num) {
        int res = 0;
        for (int i = 1; i <= num - 2; i++) {
            res = res % 1000000007 + i;
        }
        return res;
    }
}
