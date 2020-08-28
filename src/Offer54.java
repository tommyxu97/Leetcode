/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Offer54 {

    private int index = 0;
    private int res = 0;

    public int kthLargest(TreeNode root, int k) {
        recur(root, k);
        return res;
    }

    // 二叉搜索树中序倒序遍历
    public void recur(TreeNode root, int k) {
        if (root == null) return;
        recur(root.right, k);
        if (++index == k) res = root.val;
        recur(root.left, k);
    }
}
