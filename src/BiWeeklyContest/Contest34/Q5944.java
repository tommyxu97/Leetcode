package BiWeeklyContest.Contest34;

import java.util.Arrays;

public class Q5944 {

    // https://leetcode-cn.com/contest/biweekly-contest-34/
    // https://leetcode-cn.com/problems/count-all-possible-routes/

    private int map[][]; // map[i][j]记录i->j所需要的fuel
    private int dp[][]; // dp[start][fuel]记录从start到finish，fuel时的可选路线数

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        map = new int[locations.length][locations.length];
        dp = new int[locations.length][fuel + 1];

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                map[i][j] = Math.abs(locations[i] - locations[j]);
            }
        }
        for (int[] array: dp) {
            Arrays.fill(array, -1);
        }
        return dfs(start, finish, fuel);
    }

    public int dfs(int start, int finish, int fuel) {
        if (dp[start][fuel] == -1) {
            int temp = start == finish? 1: 0;
            for (int i = 0; i < dp.length; i++) {
                if (i != start && map[start][i] <= fuel) {
                    temp += dfs(i, finish, fuel - map[start][i]);
                    temp = temp % 1000000007;
                }
            }
            dp[start][fuel] = temp;
        }
        return dp[start][fuel];
    }
}
