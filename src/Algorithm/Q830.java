package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        char[] chars = s.toCharArray();
        int start = 0;
        char lastChar = chars[0];
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != lastChar) {
                if (i - start >= 3) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(start);
                    temp.add(i - 1);
                    res.add(temp);
                }
                start = i;
                if (i < chars.length) lastChar = chars[i];
            }
        }
        return res;
    }
}
