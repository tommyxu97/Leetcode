package Algorithm;

import java.util.*;

public class Q767 {
    public String reorganizeString(String S) {
        int[] letters = new int[26];
        int max = 0;
        int len = S.length();
        for (char c: S.toCharArray()) {
            letters[c - 'a']++;
            max = Math.max(letters[c - 'a'], max);
        }
        if (max > (len + 1) / 2) return "";
        char[] charArray = new char[S.length()];
        List<int[]> list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            list.add(new int[] {'a' + i, letters[i]});
        }
        list.sort(((o1, o2) -> o2[1] - o1[1]));
        int index = 0, strIndex = 0;
        while (index < list.size()) {
            int[] temp = list.get(index);
            for (int i = 0; i < temp[1]; i++) {
                if (strIndex >= charArray.length) strIndex = 1;
                charArray[strIndex] = (char) temp[0];
                strIndex += 2;
            }
            index++;
        }
        return new String(charArray);
    }
}
