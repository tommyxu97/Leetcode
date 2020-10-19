package BiWeeklyContest.Contest35;

public class Q5505 {

    // 超时
    public int minSubarray(int[] nums, int p) {
        int left = 0;
        for (int num : nums) {
            left = (left + num) % p;
        }
        if (left == 0) return 0;
        for (int len = 1; len < nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                int sum = 0;
                for (int j = len; j > 0; j--) {
                    sum += nums[i + j - 1];
                }
                if (sum % p == left) return len;
            }
        }
        return -1;
    }
}
