package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Q129 {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return res;
        recur(root, new ArrayList<>());
        return res;
    }

    // 1ms，使用List操作需要花费更多时间
    private void recur(TreeNode node, List<Integer> path) {
        if (node.left == null && node.right == null) {
            path.add(node.val);
            int temp = 0;
            for (int i = 0; i < path.size(); i++) {
                temp = temp * 10 + path.get(i);
            }
            res += temp;
            path.remove(path.size() - 1);
            return;
        }
        path.add(node.val);
        if (node.left != null) recur(node.left, path);
        if (node.right != null) recur(node.right, path);
        path.remove(path.size() - 1);
    }

    // 0ms
    private int temp = 0;
    private void recur(TreeNode node) {
        if (node.left == null && node.right == null) {
            temp = temp * 10 + node.val;
            res += temp;
            temp /= 10;
            return;
        }
        temp = temp * 10 + node.val;
        if (node.left != null) recur(node.left);
        if (node.right != null) recur(node.right);
        temp /= 10;
    }
}
