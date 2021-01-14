package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Q1018 {
    // 注意数字溢出
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int num = 0;
        for (int i : A) {
            num <<= 1;
            num += i;
            num %= 10;
            res.add(num % 5 == 0);
        }
        return res;
    }
}
