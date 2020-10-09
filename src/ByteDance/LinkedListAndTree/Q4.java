package ByteDance.LinkedListAndTree;

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
public class Q4 {
    // 与主题库Q148相同
    public ListNode sortList(ListNode head) {
        return head != null? mergeSort(head): null;
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        // 切分链表
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // 把左边最后的节点的next设置为空
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
            if (node1 != null) cur.next = node1;
            if (node2 != null) cur.next = node2;
        }
        return dummy.next;
    }
}
