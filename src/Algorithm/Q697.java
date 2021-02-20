package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q697 {
    // 24ms
    public int findShortestSubArray(int[] nums) {
        int[] counts = new int[50000];
        for (int num: nums) counts[num]++;
        int max = 0;
        HashSet<Integer> maxNums = new HashSet<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                maxNums.clear();
                maxNums.add(i);
            } else if (counts[i] == max) {
                maxNums.add(i);
            }
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (maxNums.contains(num)) {
                if (map.containsKey(num)) {
                    map.get(num).add(i);
                } else {
                    int finalI = i;
                    map.put(num, new ArrayList<Integer>(max) {{
                        add(finalI);
                    }});
                }
            }
        }
        int min = nums.length;
        for (List<Integer> indexes: map.values()) {
            min = Math.min(min, indexes.get(max - 1) - indexes.get(0) + 1);
        }
        return min;
    }

    // 6ms
    public int findShortestSubArray2(int[] nums) {
        int[] counts = new int[50000];
        int max = 0;
        for(int num: nums) {
            max = Math.max(max, ++counts[num]);
        }
        if (max == 1) return 1;
        int min = nums.length;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) {
                int start = 0, end = nums.length - 1;
                while (nums[start] != i) start++;
                while (nums[end] != i) end--;
                min = Math.min(min, end - start + 1);
            }
        }
        return min;
    }
}
