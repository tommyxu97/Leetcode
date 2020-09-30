package ByteDance.ArrayAndSort;

import java.util.Arrays;
import java.util.HashMap;

public class Q6 {
    // 与主题库Q128相同
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                temp++;
                max = Math.max(max, temp);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else temp = 1;
        }
        return max;
    }

    // O(n)
    public int longestConsecutive2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int cur = left + right + 1;
                max = Math.max(max, cur);
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return max;
    }
}
