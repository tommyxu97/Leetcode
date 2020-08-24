public class Offer42 {

    public static void main(String[] args) {
        Offer42 offer42 = new Offer42();
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(offer42.maxSubArray(test)); // Expected Output: 6
    }

    // DP
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
