import java.util.Arrays;

public class Offer61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int king = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) king++;
            else {
                if (nums[i] < nums[i + 1] - 1) {
                    if (king < nums[i + 1] - nums[i] - 1) return false;
                    else king -= nums[i + 1] - nums[i] - 1;
                } else if (nums[i] == nums[i + 1]) return false;
            }
        }
        return true;
    }
}
