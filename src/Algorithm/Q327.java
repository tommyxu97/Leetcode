package Algorithm;

public class Q327 {
    // 暴力O(n^2), 181ms
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum <= upper && sum >= lower) res++;
            }
        }
        return res;
    }
}
