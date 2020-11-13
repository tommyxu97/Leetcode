package Algorithm;

import java.util.*;

public class Q1122 {
    // 4ms
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr2) {
            set.add(num);
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: arr1) {
            if (set.contains(num)) {
                int temp = count.getOrDefault(num, 0);
                count.put(num, temp + 1);
            } else queue.add(num);
        }
        int index = 0;
        for (int num: arr2) {
            int temp = count.get(num);
            for (int i = 0; i < temp; i++) {
                arr1[index] = num; index++;
            }
        }
        while (!queue.isEmpty()) {
            arr1[index] = queue.poll(); index++;
        }
        return arr1;
    }

    // 0ms
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] res = new int[arr1.length];
        for (int num: arr1) {
            count[num]++;
        }
        int index = 0;
        for (int num: arr2) {
            while (count[num] > 0) {
                res[index] = num;
                count[num]--;
                index++;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (count[i] > 0) {
                res[index] = i;
                count[i]--;
                index++;
            }
        }
        return res;
    }
}
