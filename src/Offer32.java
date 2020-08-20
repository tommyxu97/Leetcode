import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Offer32 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2; node1.right = node3; node2.left = node4; node2.right = node5;
        Offer32 offer32 = new Offer32();
        System.out.println(Arrays.toString(offer32.levelOrder(node1)));
    }

    // 二叉树的层次遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            list.add(temp.val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        // list.stream().mapToInt(Integer::intValue).toArray()
        return res;
    }
}
