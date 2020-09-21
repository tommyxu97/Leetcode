package Algorithm;

public class Q538 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        node.val = sum + node.val;
        sum = node.val;
        dfs(node.left);
    }
}
