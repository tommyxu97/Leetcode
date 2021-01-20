package Algorithm;

import java.util.Arrays;

public class Q628 {
    // 13ms
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    // 2ms
    public int maximumProduct2(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            } else if (num > max2) {
                max1 = max2;
                max2 = num;
            } else if (num > max1) {
                max1 = num;
            }
        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }
}
