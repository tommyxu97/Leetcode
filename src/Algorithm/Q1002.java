package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q1002 {
    public List<String> commonChars(String[] A) {
        int[][] counts = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char c: A[i].toCharArray()) {
                counts[i][c - 'a']++;
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(min, counts[j][i]);
            }
            for (int temp = min; temp > 0; temp--) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}
