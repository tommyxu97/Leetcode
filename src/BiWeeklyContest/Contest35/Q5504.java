package BiWeeklyContest.Contest35;

import java.util.*;

public class Q5504 {

    // 超时
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        Arrays.sort(nums);
        int[] requestNum = new int[len];
        for (int[] request: requests) {
            for (int index = request[0]; index <= request[1]; index++) {
                requestNum[index]++;
            }
        }
        Arrays.sort(requestNum);
        long res = 0;
        for (int i = len - 1; i >= 0 && requestNum[i] != 0; i--) {
            res = (res + nums[i] * requestNum[i]) % 1000000007;
        }
        return (int) res;
    }
}
