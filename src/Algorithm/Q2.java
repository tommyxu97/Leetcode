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
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, cur = dummy;
        int flag = 0;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + flag;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            flag = sum >= 10? 1: 0;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int sum = cur1.val + flag;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cur1 = cur1.next;
            flag = sum >= 10? 1: 0;
        }
        while (cur2 != null) {
            int sum = cur2.val + flag;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cur2 = cur2.next;
            flag = sum >= 10? 1: 0;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
