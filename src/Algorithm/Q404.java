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
public class Q404 {

    private int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.left.left == null && node.left.right == null) res += node.left.val;
        dfs(node.left);
        dfs(node.right);
    }
}
