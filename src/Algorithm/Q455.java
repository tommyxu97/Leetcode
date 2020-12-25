package Algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q455 {
    // 27ms
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> children = new PriorityQueue<>();
        PriorityQueue<Integer> cookies = new PriorityQueue<>();
        int res = 0;
        for (int child: g) children.add(child);
        for (int cookie: s) cookies.add(cookie);
        while (!children.isEmpty() && !cookies.isEmpty()) {
            if (children.peek() <= cookies.peek()) {
                children.remove(); cookies.remove();
                res++;
            } else {
                cookies.remove();
            }
        }
        return res;
    }

    // 8ms
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, index = 0;
        for (int i = 0; i < g.length && index < s.length; i++) {
            if (g[i] <= s[index]) res++;
            else i--;
            index++;
        }
        return res;
    }
}
