package Algorithm;

import java.util.Arrays;

public class Q153 {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[0];
    }
}
