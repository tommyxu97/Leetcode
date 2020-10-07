package ByteDance.LinkedListAndTree;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q3 {
    // 与主题库Q2相同
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, flag = 0;
        ListNode dummy = new ListNode(0);
        ListNode node1 = l1, node2 = l2, cur = dummy;
        while (node1 != null && node2 != null) {
            sum = node1.val + node2.val + flag;
            flag = sum >= 10? 1: 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode left = node1 == null? node2: node1;
        while (left != null) {
            sum = left.val + flag;
            flag = sum >= 10? 1: 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            left = left.next;
        }
        if (flag == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
