package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q842 {
    private List<Integer> res = new LinkedList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() < 3) return res;
        recur(S, 0);
        return res;
    }

    private boolean recur(String str, int index) {
        if (index == str.length()) return res.size() >= 3;
        for (int i = 1; i <= str.length() - index; i++) {
            String substring = str.substring(index, index + i);
            long tempLong = Long.parseLong(substring);
            if (tempLong > Integer.MAX_VALUE) break;
            int temp = (int) tempLong;
            if (res.size() >= 2 && temp != res.get(res.size() - 1) + res.get(res.size() - 2)) continue;
            if (str.charAt(index) == '0' && i >= 2) break;
            res.add(temp);
            boolean flag = recur(str, index + i);
            if (flag) return true;
            res.remove(res.size() - 1);
        }
        return false;
    }
}
