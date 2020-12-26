package PinduoduoTest1023;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Set<Character> letters = new HashSet<>();
        for (char c: str.toCharArray()) letters.add(c);
        int left = 0, right = 0;
        int[] letterCount = new int[26];
        letterCount[str.charAt(left) - 'a']++;
        List<String> substrings = new LinkedList<>();
        while (true) {
            if (isValid(letters, letterCount)) {
                substrings.add(str.substring(left, right + 1));
                letterCount[str.charAt(left) - 'a']--;
                left++;
            } else {
                right++;
                if (right == str.length()) break;
                letterCount[str.charAt(right) - 'a']++;
            }
        }
        substrings.sort(String::compareTo);
        int len = substrings.get(0).length();
        int startIndex = 0, temp = 0, startNew = 0;
        while ((temp = str.indexOf(substrings.get(0), startNew)) != -1) {
            startIndex = temp;
            startNew = startIndex + len;
        }
        System.out.println(startIndex + " " + len);
    }

    private static boolean isValid(Set<Character> set, int[] array) {
        for (char c: set) {
            if (array[c - 'a'] == 0) return false;
        }
        return true;
    }
}
