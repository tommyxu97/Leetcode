import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Offer34 {

    public static void main(String[] args) {

    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new LinkedList<>();
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    // 递归
    public void dfs(TreeNode node, int sum, List<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        sum = sum - node.val;
        if (sum == 0 && node.left == null && node.right == null) res.add(new ArrayList<>(path)); // 需要到达叶子节点
        dfs(node.left, sum, path); dfs(node.right, sum, path);
        path.remove(path.size() - 1);
    }
}
