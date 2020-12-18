package Algorithm;

import java.util.Arrays;

public class Q389 {
    // 3ms
    public char findTheDifference(String s, String t) {
        char[] original = s.toCharArray();
        char[] modified = t.toCharArray();
        Arrays.sort(original);
        Arrays.sort(modified);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != modified[i]) return modified[i];
        }
        return modified[modified.length - 1];
    }

    // 1ms
    public char findTheDifference2(String s, String t) {
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) return (char) (i + 'a');
        }
        return 'a';
    }
}
