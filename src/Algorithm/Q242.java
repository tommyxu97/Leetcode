package Algorithm;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        int[] letter = new int[26];
        for (char c: s.toCharArray()) {
            letter[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            letter[c - 'a']--;
        }
        for (int i: letter) {
            if (i != 0) return false;
        }
        return true;
    }
}
