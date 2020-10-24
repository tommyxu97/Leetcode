package Algorithm;

public class Q55 {
    // 贪心
    public boolean canJump(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (right >= i) {
                right = Math.max(nums[i] + i, right);
                if (right >= nums.length - 1) return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
