package Algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q145 {

    private List<Integer> res = new ArrayList<>();

    // 递归算法
    public List<Integer> postorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }

    private void recur(TreeNode node) {
        if (node == null) return;
        recur(node.left);
        recur(node.right);
        res.add(node.val);
    }

    // 迭代算法
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.addLast(cur);
                cur = cur.left;
            }
            cur = deque.peekLast();
            if (cur.right == null || cur.right == pre) {
                res.add(cur.val);
                deque.removeLast();
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
