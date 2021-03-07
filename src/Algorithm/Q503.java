package Algorithm;

import java.util.Arrays;

public class Q503 {
    // 66ms
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n * 2];
        System.arraycopy(nums, 0, newNums, 0, n);
        System.arraycopy(nums, 0, newNums, n, n);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                if (newNums[j] > newNums[i]) {
                    res[i] = newNums[j];
                    break;
                }
            }
        }
        return res;
    }
}
