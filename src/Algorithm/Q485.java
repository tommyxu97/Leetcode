package Algorithm;

public class Q485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = -1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                res = Math.max(res, i - start - 1);
                start = i;
            }
        }
        res = Math.max(res, nums.length - start - 1);
        return res;
    }
}
