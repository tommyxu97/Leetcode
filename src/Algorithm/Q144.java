package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q144 {
    private List<Integer> res = new LinkedList<>();

    // 递归算法
    public List<Integer> preorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }

    private void recur(TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        recur(node.left);
        recur(node.right);
    }

    // 迭代算法
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
