package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int len = S.length();
        int[] lastIndex = new int[26];
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < len; i++) {
            end = Math.max(lastIndex[S.charAt(i) - 'a'], end);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
