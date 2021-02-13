package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q448 {
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
}
