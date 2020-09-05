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
public class Offer27 {

    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }

    public void swap(TreeNode node) {
        if (node == null) return;
        TreeNode temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        swap(node.left); swap(node.right);
    }
}
