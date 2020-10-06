package Algorithm;

import java.util.*;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 4) return res;
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] + nums[3] > target || nums[len - 1] + nums[len - 2] +
                nums[len - 3] + nums[len - 4] < target) return res;
        for(int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
                int start = j + 1, end = len - 1;
                while (start < end) {
                    if (nums[i] + nums[j] + nums[start] + nums[end] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++; end--;
                        while (nums[start] == nums[start - 1] && start < end) start++;
                        while (nums[end] == nums[end + 1] && start < end) end--;
                    } else if (nums[i] + nums[j] + nums[start] + nums[end] < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}
