package ByteDance.String;

import java.util.*;

public class Q7 {

    // 与主题库Q93相同
    private List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) return new LinkedList<>();
        Deque<String> temp = new ArrayDeque<>(4);
        dfs(s, 0, 0, temp);
        return res;
    }

    public void dfs(String s, int start, int depth, Deque<String> temp) {
        if (start == s.length() && depth == 4) {
            res.add(String.join(".", temp));
            return;
        }
        if (s.length() - start < (4 - depth) || s.length() - start > (4 - depth) * 3) return;
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break;
            String substring = s.substring(start, start + i);
            if (isIPSegment(substring)) {
                temp.addLast(substring);
                dfs(s, start + i, depth + 1, temp);
                temp.removeLast();
            }
        }
    }

    public boolean isIPSegment(String s) {
        if (Integer.parseInt(s) > 255) return false;
        if (s.charAt(0) == '0') {
            return s.length() <= 1;
        }
        return true;
    }
}
