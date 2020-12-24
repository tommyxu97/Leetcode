package Algorithm;

public class Q387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char c: chars) counts[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (counts[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
