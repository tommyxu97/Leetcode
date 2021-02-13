package Algorithm;

import java.util.*;

public class Q448 {
    // 20ms
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        List<Integer> res = new ArrayList<>(n - set.size());
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) res.add(i);
        }
        return res;
    }

    // 4ms
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        boolean[] flags = new boolean[n + 1];
        for (int num: nums) flags[num] = true;
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i < flags.length; i++) {
            if (!flags[i]) res.add(i);
        }
        return res;
    }
}
