package SwordToOffer;

public class Offer28 {

    public static void main(String[] args) {

    }

    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judgeSubTree(root.left, root.right);
    }

    private boolean judgeSubTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && judgeSubTree(left.left, right.right) && judgeSubTree(left.right, right.left);
    }
}
