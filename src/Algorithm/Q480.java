package Algorithm;

import java.util.Arrays;

public class Q480 {
    // 2603ms，暴力解
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) return new double[0];
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            int[] window = new int[k];
            if (i + k - i >= 0) System.arraycopy(nums, i, window, 0, i + k - i);
            Arrays.sort(window);
            res[i] = k % 2 == 1? window[k / 2]: ((double) window[k / 2 - 1] / 2 + (double) window[k / 2] / 2);
        }
        return res;
    }

    // 30ms，二分搜索与插入
    public double[] medianSlidingWindow2(int[] nums, int k) {
        int index = 0;
        double[] res = new double[nums.length - k + 1];
        int[] window = Arrays.copyOf(nums, k);
        Arrays.sort(window);
        res[index++] = window[k / 2] * 0.5 + window[(k - 1) / 2] * 0.5;
        for (int i = k; i < nums.length; i++) {
            int temp = binarySearch(window, nums[i - k]);
            insert(window, nums[i], temp);
            res[index++] = window[k / 2] * 0.5 + window[(k - 1) / 2] * 0.5;
        }
        return res;
    }

    private void insert(int[] nums, int num, int index) {
       if (index == 0 || (index + 1 < nums.length && num > nums[index + 1])) {
           int i = index + 1;
           while (i < nums.length && nums[i] < num) {
               nums[i - 1] = nums[i];
               i++;
           }
           nums[i - 1] = num;
       } else if (index == nums.length - 1 || (index > 0 && num < nums[index - 1])) {
           int i = index - 1;
           while (i >= 0 && nums[i] > num) {
               nums[i + 1] = nums[i];
               i--;
           }
           nums[i + 1] = num;
       } else nums[index] = num;
    }

    private int binarySearch(int[] nums, int num) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
