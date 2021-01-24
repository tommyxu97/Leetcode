package Algorithm;

public class Q674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res = Math.max(res, i - start);
                start = i;
            }
        }
        res = Math.max(res, nums.length - start);
        return res;
    }
}
