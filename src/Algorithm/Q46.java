package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q46 {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) temp.add(num);
            res.add(temp);
        }
        for (int i = startIndex; i < nums.length; i++) {
            swap(nums, startIndex, i);
            dfs(nums, startIndex + 1);
            swap(nums, startIndex, i);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
