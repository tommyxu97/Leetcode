package SwordToOffer;

/**
 * Definition for singly-linked list.
 * public class SwordToOffer.ListNode {
 *     int val;
 *     SwordToOffer.ListNode next;
 *     SwordToOffer.ListNode(int x) { val = x; }
 * }
 */
public class Offer18 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2; node2.next = node3; node3.next = node4;
        Offer18 offer18 = new Offer18();
        offer18.deleteNode(node1, 9);
        ListNode cur = node1;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    // 双指针
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = pre.next;
        }
        return head;
    }

    // 单指针
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
