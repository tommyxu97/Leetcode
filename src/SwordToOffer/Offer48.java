package SwordToOffer;

import java.util.HashMap;

public class Offer48 {

    public static void main(String[] args) {
        Offer48 offer48 = new Offer48();
        System.out.println(offer48.lengthOfLongestSubstring("abcdecdafcdgi")); // Expected: 6
    }

    // 双指针
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, max = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        while (end < s.length()) {
            char temp = s.charAt(end);
            if (indexMap.containsKey(temp) && indexMap.get(temp) >= start) start = indexMap.get(temp) + 1;
            indexMap.put(temp, end);
            end ++;
            max = Math.max(max, end - start);
        }
        return max;
    }
    // DP
    public int lengthOfLongestSubstring2(String s) {
        int res = 0, temp = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = indexMap.getOrDefault(s.charAt(i), -1);
            indexMap.put(s.charAt(i), i);
            temp = temp < i - index? temp + 1: i - index;
            res = Math.max(res, temp);
        }
        return res;
    }
}
