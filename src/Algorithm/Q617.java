package Algorithm;

public class Q617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int sum = 0;
        if (t1 != null) sum += t1.val;
        if (t2 != null) sum += t2.val;
        TreeNode node = new TreeNode(sum);
        TreeNode left = mergeTrees(t1 != null? t1.left: null, t2 != null? t2.left: null);
        TreeNode right = mergeTrees(t1 != null? t1.right: null, t2 != null? t2.right: null);
        node.left = left;
        node.right = right;
        return node;
    }

    // 修改原树速度更快
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);
        return t1;
    }
}
