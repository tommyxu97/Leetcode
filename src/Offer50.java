import java.util.HashMap;

public class Offer50 {

    public static void main(String[] args) {
        Offer50 offer50 = new Offer50();
        System.out.println(offer50.firstUniqChar("adaigydvbiwbdviwboqjuhruifas")); // Expected: g
    }

    // 哈希表 36ms
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) map.put(c, false);
            else map.put(c, true);
        }
        for (char c: s.toCharArray()) {
            if (map.containsKey(c) && map.get(c)) return c;
        }
        return ' ';
    }

    // 直接使用静态数组 6ms
    public char firstUniqChar2(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) count[c - 'a']++;
        for (char c: s.toCharArray()) {
            if (count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
