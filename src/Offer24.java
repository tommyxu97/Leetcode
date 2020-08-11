/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Offer24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
        Offer24 offer24 = new Offer24();
        System.out.println(offer24.reverseList(node1).val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, pre = null, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
