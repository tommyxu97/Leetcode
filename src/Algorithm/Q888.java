package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class Q888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        if (A == null || B == null) return new int[2];
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: A) {
            sumA += num;
            set.add(num);
        }
        for (int num: B) sumB += num;
        for (int num: B) {
            if (set.contains((sumA + 2 * num - sumB) / 2)) {
                return new int[] {(sumA + 2 * num - sumB) / 2, num};
            }
        }
        return new int[2];
    }
}
