package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q39 {
    private List<List<Integer>> res = new LinkedList<>();
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        nums = candidates;
        dfs(target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int target, int startIndex, List<Integer> temp) {
        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            if (target > num) {
                temp.add(num);
                dfs(target - num, i, temp);
                temp.remove(temp.size() - 1);
            } else if (target == num) {
                temp.add(num);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
        }
    }
}
