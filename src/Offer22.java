/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Offer22 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2; node2.next = node3; node3.next = node4;
        Offer22 offer22 = new Offer22();
        System.out.println(offer22.getKthFromEnd(node1, 3).val);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        int i = k - 1;
        ListNode cur = head ,tail = head;
        while (i > 0) {
            tail = tail.next;
            i --;
        }
        while (tail.next != null) {
            cur = cur.next;
            tail = tail.next;
        }
        return cur;
    }
}


