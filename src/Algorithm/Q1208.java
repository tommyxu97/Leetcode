package Algorithm;

public class Q1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] delta = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            delta[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0, max = 0, cost = 0;
        while (right < s.length()) {
            cost += delta[right];
            while (left <= right && cost > maxCost) {
                cost -= delta[left];
                left++;
            }
            if (cost <= maxCost) max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
