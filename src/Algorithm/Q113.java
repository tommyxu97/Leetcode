package Algorithm;

import java.util.*;

public class Q113 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();
    private int temp = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        path.addLast(node.val);
        temp += node.val;
        if (node.left == null && node.right == null) {
            if (temp == sum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
        path.removeLast();
        temp -= node.val;
    }
}
