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
public class Offer68_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
