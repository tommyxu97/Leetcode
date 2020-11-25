package Algorithm;

public class Q1370 {
    public String sortString(String s) {
        int[] letters = new int[26];
        for (char c: s.toCharArray()) {
            letters[c - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] != 0) {
                    stringBuilder.append((char) ('a' + i));
                    letters[i]--;
                    flag = true;
                }
            }
            for (int i = letters.length - 1; i >= 0; i--) {
                if (letters[i] != 0) {
                    stringBuilder.append((char) ('a' + i));
                    letters[i]--;
                    flag = true;
                }
            }
        }
        return stringBuilder.toString();
    }
}
