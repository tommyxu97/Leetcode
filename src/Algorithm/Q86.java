package Algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode curL = l, curR = r;
        while (head != null) {
            if (head.val < x) {
                curL.next = head;
                curL = curL.next;
            } else {
                curR.next = head;
                curR = curR.next;
            }
            head = head.next;
        }
        curL.next = r.next;
        curR.next = null;
        return l.next;
    }
}
