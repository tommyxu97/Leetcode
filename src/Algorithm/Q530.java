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
public class Q530 {
    private int pre = -1;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            min = Math.min(min, node.val - pre);
            pre = node.val;
        }
        dfs(node.right);
    }
}
