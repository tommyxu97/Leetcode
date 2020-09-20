package WeeklyContest.Contest207;

import java.util.HashSet;
import java.util.Set;

public class Q5520 {

    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.substring(2, 3));
    }

    private int res = 0;
    private Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
        if (s.length() == 0) return 0;
        for (int i = 1; i <= s.length(); i++) {
            dfs(s, 0, i);
        }
        return res;
    }

    private void dfs(String s, int start, int len) {
        if (start == s.length()) {
            res = Math.max(res, set.size());
        }
        if (start + len > s.length() || set.contains(s.substring(start, start + len))) return;
        String substring = s.substring(start, start + len);
        set.add(substring);
        for (int i = 1; i <= s.length() - (start + len) + 1; i++) {
            dfs(s, start + len, i);
        }
        set.remove(substring);
    }
}
