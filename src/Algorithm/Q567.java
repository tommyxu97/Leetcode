package Algorithm;

public class Q567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int len = s1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len; i++) count1[s1.charAt(i) - 'a']++;
        for (int i = 0; i < len; i++) count2[s2.charAt(i) - 'a']++;
        for (int i = len; i < s2.length(); i++) {
            if (isEqual(count1, count2)) return true;
            count2[s2.charAt(i - len) - 'a']--;
            count2[s2.charAt(i) - 'a']++;
        }
        return isEqual(count1, count2);
    }

    private boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
