package GoogleKickStart.RoundG2020;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        for (int num = 1; num <= nums; num++) {
            int counts = scanner.nextInt();
            long res = 0;
            Node dummy = new Node(-1), cur = dummy, max = dummy;
            for (int count = 0; count < counts; count++) {
                cur.next = new Node(scanner.nextInt());
                cur.next.pre = cur;
                cur = cur.next;
                if (cur.value > max.value) max = cur;
            }
            while (true) {
                if (max.pre == dummy) {
                    if (max.next == null) break;
                    max.value = max.value + max.next.value;
                    max.next = max.next.next;
                    if (max.next != null) max.next.pre = max;
                } else if (max.next == null) {
                    max.value = max.value + max.pre.value;
                    max.pre = max.pre.pre;
                    max.pre.next = max;
                } else if (max.pre.value <= max.next.value) {
                    max.value = max.value + max.next.value;
                    max.next = max.next.next;
                    if (max.next != null) max.next.pre = max;
                } else {
                    max.value = max.value + max.pre.value;
                    max.pre = max.pre.pre;
                    max.pre.next = max;
                }
                res += max.value;
                if (dummy.next == max && max.next == null) break;
            }
            System.out.println("Case #" + num + ": " + res);
        }
    }

    static class Node{
        Node pre, next;
        int value;
        Node(int v) {
            value = v;
        }
    }
}
