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
public class Q148 {
    // Select Sort
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0), temp, cur;
        dummy.next = head;
        while (head.next != null) {
            if (head.val < head.next.val) {
                head = head.next;
                continue;
            }
            cur = head.next;
            head.next = cur.next;
            temp = dummy;
            while (temp.next.val < cur.val) temp = temp.next;
            cur.next = temp.next;
            temp.next = cur;
        }
        return dummy.next;
    }

    // Merge Sort
    public ListNode sortList2(ListNode head) {
        return null;
    }

    // Quick Sort
    public ListNode sortList3(ListNode head) {
        return null;
    }
}
