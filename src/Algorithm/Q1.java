package Algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class Q1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15}; int target = 9;
        System.out.println(Arrays.toString(new Q1().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};
            else map.put(left, i);
        }
        return new int[0];
    }
}
