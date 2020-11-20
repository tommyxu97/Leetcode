package Algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE), pre;
        dummy.next = head;
        while (head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val < head.next.val) pre = pre.next;
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }
}
