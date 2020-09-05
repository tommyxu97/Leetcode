package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

public class Offer57_2 {

    // 滑动窗口，最好设置为左闭右开，即[1,2)代表窗口内只有1这个数
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 0;
        List<int[]> res = new ArrayList<>();
        while (j <= target/2 + 2) {
            if (sum < target) {
                sum += j++;
            } else if (sum > target) {
                sum -= i++;
            } else {
                int[] nums = new int[j - i];
                for (int k = i; k < j; k++) {
                    nums[k - i] = k;
                }
                res.add(nums);
                sum -= i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
