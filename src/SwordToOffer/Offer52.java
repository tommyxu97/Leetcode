package SwordToOffer;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class SwordToOffer.ListNode {
 *     int val;
 *     SwordToOffer.ListNode next;
 *     SwordToOffer.ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Offer52 {

    // 运行速度慢
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node)) return node;
            node = node.next;
        }
        return null;
    }

    // 双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null? node1.next: headB;
            node2 = node2 != null? node2.next: headA;
        }
        return node1;
    }
}
