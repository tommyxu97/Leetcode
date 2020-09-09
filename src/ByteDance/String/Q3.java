package ByteDance.String;

import java.util.HashMap;

public class Q3 {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 && len2 == 0) return false;
        if (len1 > len2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (isSame(count1, count2)) return true;
        for (int i = len1; i < len2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - len1) - 'a']--;
            if (isSame(count1, count2)) return true;
        }
        return false;
    }

    public boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
