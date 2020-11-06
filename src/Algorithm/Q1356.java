package Algorithm;

import java.util.Arrays;

public class Q1356 {
    // 8ms
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, (o1, o2) -> {
            int bitCount1 = Integer.bitCount(o1);
            int bitCount2 = Integer.bitCount(o2);
            return bitCount1 != bitCount2? bitCount1 - bitCount2: o1 - o2;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    // 3ms
    public int[] sortByBits2(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ans[i] % 10000000;
        }
        return ans;
    }
}
