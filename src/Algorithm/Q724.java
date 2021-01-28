package Algorithm;

public class Q724 {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0;
        for (int num: nums) sum += num;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
