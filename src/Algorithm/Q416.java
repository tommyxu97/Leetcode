package Algorithm;

import java.util.Arrays;

public class Q416 {
    // DP
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    // DFS 会超时过不了测试
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;
        if ((sum & 1) == 1) return false;
        Arrays.sort(nums);
        return dfs(nums, sum / 2, 0);
    }

    private boolean dfs(int[] nums, int target, int index) {
        if (target == 0) return true;
        for (int i = index; i < nums.length && nums[i] <= target; i++) {
            if (i > index && nums[i] == nums[i -1]) continue;
            if (dfs(nums, target - nums[i], i + 1)) return true;
        }
        return false;
    }
}
