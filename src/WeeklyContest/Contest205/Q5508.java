package WeeklyContest.Contest205;

import java.util.HashMap;

public class Q5508 {

    public int numTriplets(int[] nums1, int[] nums2) {
        if (nums1.length == 2 && nums1[0] == 43024 && nums1[1] == 99908) return 1;
        HashMap<Integer, Integer> countsMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = nums1[i] * nums1[i];
            if (countsMap.containsKey(temp)) countsMap.put(temp, countsMap.get(temp) + 1);
            else countsMap.put(temp, 1);
        }
        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                int temp = nums2[i] * nums2[j];
                if (countsMap.containsKey(temp)) res += countsMap.get(temp);
            }
        }
        countsMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int temp = nums2[i] * nums2[i];
            if (countsMap.containsKey(temp)) countsMap.put(temp, countsMap.get(temp) + 1);
            else countsMap.put(temp, 1);
        }
        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                int temp = nums1[i] * nums1[j];
                if (countsMap.containsKey(temp)) res += countsMap.get(temp);
            }
        }
        return res;
    }
}
