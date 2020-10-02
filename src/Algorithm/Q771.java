package Algorithm;

import java.util.HashSet;

public class Q771 {
    public int numJewelsInStones(String J, String S) {
        if (S.length() == 0) return 0;
        int res = 0;
        char[] jewels = J.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            for (char c: jewels) {
                if (S.charAt(i) == c) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public int numJewelsInStones2(String J, String S) {
        if (S.length() == 0) return 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c: J.toCharArray()) {
            set.add(c);
        }
        for (char c: S.toCharArray()) {
            if (set.contains(c)) res++;
        }
        return res;
    }
}
