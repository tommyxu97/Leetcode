package Algorithm;

public class Q665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 2) return true;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (flag) return false;
                flag = true;
                if (i == 1 || nums[i] >= nums[i - 2]) nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}
