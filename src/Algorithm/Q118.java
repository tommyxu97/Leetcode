package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
