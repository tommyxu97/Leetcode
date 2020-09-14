package ByteDance.ArrayAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q1 {

    // 与主题库Q15相同
    // 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (nums[i] == num) continue;
            num = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) left++;
                else if (nums[i] + nums[left] + nums[right] > 0) right--;
                else {
                    ArrayList<Integer> temp = new ArrayList<>(3);
                    temp.add(nums[i]); temp.add(nums[left]); temp.add(nums[right]);
                    res.add(temp);
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++; right--;
                }
            }
        }
        return res;
    }
}
