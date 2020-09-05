package SwordToOffer;

/**
 * Definition for a binary tree node.
 * public class SwordToOffer.TreeNode {
 *     int val;
 *     SwordToOffer.TreeNode left;
 *     SwordToOffer.TreeNode right;
 *     SwordToOffer.TreeNode(int x) { val = x; }
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
