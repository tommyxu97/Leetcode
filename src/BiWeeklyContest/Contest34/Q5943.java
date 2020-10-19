package BiWeeklyContest.Contest34;

import java.util.ArrayList;
import java.util.List;

public class Q5943 {

    // https://leetcode-cn.com/contest/biweekly-contest-34/
    // https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

    public int findLengthOfShortestSubarray(int[] arr) {
        List<Integer> position = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) position.add(i);
        }
        if (position.size() == 0) return 0;
        int start = position.get(0) + 1, end = position.get(position.size() - 1) + 1;
        int temp = arr.length - end, maxLen = temp;
        int left = 0, right = end;
        while (left < start && right < arr.length) { // 双指针
            if (arr[left] <= arr[right]) {
                left ++;
                temp ++;
                maxLen = Math.max(temp, maxLen);
            } else {
                right ++;
                temp --;
            }
        }
        return arr.length - maxLen;
    }
}
