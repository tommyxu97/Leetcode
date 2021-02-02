package Algorithm;

public class Q424 {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        int left = 0, right = 0;
        int max = 0;
        while (right < chars.length) {
            count[chars[right] - 'A']++;
            max = Math.max(max, count[chars[right] - 'A']);
            if (right - left + 1 - max > k) {
                count[chars[left] - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
