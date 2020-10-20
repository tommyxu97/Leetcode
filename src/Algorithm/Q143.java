package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Q143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int left = 1, right = nodes.size() - 1;
        cur = head;
        while (left <= right) {
            cur.next = nodes.get(right);
            cur = cur.next;
            right--;
            cur.next = nodes.get(left);
            cur = cur.next;
            left++;
        }
        cur.next = null;
    }
}
