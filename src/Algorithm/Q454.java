package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Q454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: A) for (int b: B) map.compute(a + b, (k, v) -> v == null? 1: v + 1);
        for (int c: C) for (int d: D) res += map.getOrDefault(- c - d, 0);
        return res;
    }
}
