package Algorithm;

public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, node1 = head, node2 = head;
        while (n > 0) {
            if (node2 == null) return head;
            node2 = node2.next;
            n--;
        }
        while (node2 != null) {
            pre = node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        pre.next = node1.next;
        return dummy.next;
    }
}
