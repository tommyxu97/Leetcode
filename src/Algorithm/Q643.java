package Algorithm;

public class Q643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return (double) max / k;
    }
}
