package Algorithm;

import java.util.Arrays;

public class Q53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
