package WeeklyContest.Contest209;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Q5532 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int flag = deep % 2;
            int pre = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val % 2 == flag) return false;
                if (i == 0) pre = node.val;
                else {
                    if (flag == 0) {
                        if (pre >= node.val) return false;
                    } else if (flag == 1){
                        if (pre <= node.val) return false;
                    }
                }
                pre = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            deep++;
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
