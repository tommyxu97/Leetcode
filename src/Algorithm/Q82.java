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
public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            if (cur.next != next) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return dummyHead.next;
    }
}
