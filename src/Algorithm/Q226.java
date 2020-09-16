package Algorithm;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        recur(root);
        return root;
    }

    private void recur(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        recur(node.left);
        recur(node.right);
    }
}
