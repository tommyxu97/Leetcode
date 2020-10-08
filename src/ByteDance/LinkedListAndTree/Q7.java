package ByteDance.LinkedListAndTree;

import java.util.PriorityQueue;

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
public class Q7 {
    // 与主题库Q23相同
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy, temp;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (int i = 0; i < lists.length; i++) {
            temp = lists[i];
            while (temp != null) {
                minHeap.add(temp);
                temp = temp.next;
            }
        }
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur.next.next = null;
            cur = cur.next;
        }
        return dummy.next;
    }
}
