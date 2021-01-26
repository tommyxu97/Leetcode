package Algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class Q1128 {
    // 13ms
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] domino: dominoes) {
            if (domino[0] > domino[1]) {
                swap(domino);
            }
            int hashcode = Arrays.hashCode(domino);
            int num = map.getOrDefault(hashcode, 0);
            res += num;
            map.put(hashcode, num + 1);
        }
        return res;
    }

    private void swap(int[] domino) {
        int temp = domino[0];
        domino[0] = domino[1];
        domino[1] = temp;
    }

    // 3ms
    public int numEquivDominoPairs2(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) return 0;
        int res = 0;
        int[] count = new int[100];
        for (int[] domino: dominoes) {
            if (domino[0] > domino[1]) swap(domino);
            res += count[domino[0] * 10 + domino[1]]++;
        }
        return res;
    }
}
