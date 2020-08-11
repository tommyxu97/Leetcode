/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Offer26 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2; node1.right = node3; node2.left = node4; node2.right = node5;

        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(3);
        node6.left = node7; node6.right = node8;
        System.out.println(new Offer26().isSubStructure(node1, node6));

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean judge(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return judge(A.left, B.left) && judge(A.right, B.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}