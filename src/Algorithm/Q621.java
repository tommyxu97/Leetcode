package Algorithm;

import java.util.Arrays;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c: tasks) {
            counts[c - 'A']++;
        }
        Arrays.sort(counts);
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (counts[i] == counts[25]) {
                maxCount++;
            } else break;
        }
        return Math.max((counts[25] - 1) * (n + 1)+ maxCount, tasks.length);
    }
}
