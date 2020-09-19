package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q47 {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int i: nums) temp.add(i);
            res.add(temp);
        }
        for (int i = start; i < nums.length; i++) {
            if (canSwap(nums, start, i)) {
                swap(nums, start, i);
                dfs(nums, start + 1);
                swap(nums, start, i);
            }
        }
    }

    private boolean canSwap(int[] nums, int start, int cur) {
        for (int i = start; i < cur; i++) {
            if (nums[i] == nums[cur]) return false;
        }
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
