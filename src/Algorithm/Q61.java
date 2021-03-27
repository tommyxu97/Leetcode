package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int start = list.size() - k % list.size();
        if (start == 0 || k % list.size() == 0) return head;
        head = list.get(start);
        list.get(list.size() - 1).next = list.get(0);
        list.get(start - 1).next = null;
        return head;
    }
}
