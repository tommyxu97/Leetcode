package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Q234 {
    // 3ms
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<ListNode> nodes = new ArrayList<>();
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        for (int i = 0; i < nodes.size() / 2; i++) {
            if (nodes.get(i).val != nodes.get(nodes.size() - 1 - i).val) return false;
        }
        return true;
    }

    // 1ms
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode node1 = head, node2 = reverseList(slow);
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
