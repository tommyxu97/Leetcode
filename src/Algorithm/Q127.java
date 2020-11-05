package Algorithm;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) return 0;
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int res = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            res++;
            if (queue1.size() > queue2.size()) {
                Queue<String> tempQueue = queue1;
                queue1 = queue2;
                queue2 = tempQueue;
                Set<String> tempSet = visited1;
                visited1 = visited2;
                visited2 = tempSet;
            }
            int size = queue1.size();
            while (size > 0) {
                String str = queue1.poll();
                size--;
                assert str != null;
                char[] charArray = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {
                    char temp = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[i] = c;
                        String newString = String.valueOf(charArray);
                        if (visited1.contains(newString)) continue;
                        if (visited2.contains(newString)) return res + 1;
                        if (dict.contains(newString)) {
                            queue1.offer(newString); visited1.add(newString);
                        }
                    }
                    charArray[i] = temp;
                }
            }
        }
        return 0;
    }
}
