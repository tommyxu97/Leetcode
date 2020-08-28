/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Offer55_1 {

    private int depth = 0;
    private int cur = 0;

    public int maxDepth(TreeNode root) {
        recur(root);
        return depth;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        cur++;
        depth = Math.max(depth, cur);
        recur(root.left);
        recur(root.right);
        cur--;
    }
}
