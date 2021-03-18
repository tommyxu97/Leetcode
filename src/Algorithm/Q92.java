package Algorithm;

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
public class Q92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, next = null, cur = dummy.next;
        for (int i = 0; i < left - 1; i++) {
            pre = cur;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
