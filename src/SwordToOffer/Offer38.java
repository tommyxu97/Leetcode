package SwordToOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Offer38 {

    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        System.out.println(Arrays.toString(offer38.permutation("abcde")));
    }

    // DFS
    private char[] chars;
    private List<String> res = new LinkedList<>();

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int index) {
        if (index == chars.length - 1) {
            res.add(String.copyValueOf(chars)); return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(index, i);
            dfs(index + 1);
            swap(index, i);
        }
    }

    private void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
