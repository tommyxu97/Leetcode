package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) return res;
        recur(n, 0, 0, "", res);
        return res;
    }

    private void recur(int n, int count1, int count2, String ans, List<String> res) {
        if (count1 > n || count2 > n) return;
        if (count1 == n && count2 == n) {
            res.add(ans);
        }
        if (count1 >= count2) {
            recur(n, count1 + 1, count2, ans + "(", res);
            recur(n, count1, count2 + 1, ans + ")", res);
        }
    }
}
