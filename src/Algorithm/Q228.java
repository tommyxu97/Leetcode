package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == i - 1) res.add(String.valueOf(nums[start]));
                else res.add(nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }
        if (start == nums.length - 1) res.add(String.valueOf(nums[start]));
        else res.add(nums[start] + "->" + nums[nums.length - 1]);
        return res;
    }
}
