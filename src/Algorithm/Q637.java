package Algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q637 {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            double tempRes = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                tempRes += tempNode.val;
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            tempRes /= size;
            res.add(tempRes);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}