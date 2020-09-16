package ByteDance.ArrayAndSort;

public class Q4 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) temp++;
            else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
}
