package SwordToOffer;

import java.util.HashSet;

public class Offer57_1 {

    // 双指针，效率更高
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[]{};
    }

    // HashSet
    public int[] twoSum2(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(target - num)) return new int[]{num, target - num};
            else set.add(num);
        }
        return new int[]{};
    }
}
