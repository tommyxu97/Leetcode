package WeeklyContest.Contest209;

import java.util.Arrays;

public class Q5531 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums.length <= nums[0]) return nums.length;
            else if (nums.length - i <= nums[i] && nums.length - i > nums[i - 1]) return nums.length - i;
        }
        return -1;
    }
}
