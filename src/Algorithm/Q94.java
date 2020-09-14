package Algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q94 {

    private List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        res.add(node.val);
        inorderTraversal(node.right);
    }
}
