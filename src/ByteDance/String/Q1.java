package ByteDance.String;

import java.util.HashMap;

public class Q1 {

    // 与主题库Q3，剑指Offer48相同

    // 双指针
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        while (right < s.length()) {
            if (indexMap.containsKey(s.charAt(right))) {
                left = Math.max(indexMap.get(s.charAt(right)) + 1, left);
            }
            max = Math.max(right - left + 1, max);
            indexMap.put(s.charAt(right), right);
            right ++;
        }
        return max;
    }
}
