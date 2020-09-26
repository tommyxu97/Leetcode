package Algorithm;

import java.util.Arrays;

public class Q106 {

    // 时间空间效率一般
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(postorder[len - 1]);
        int index = findIndex(postorder[len - 1], inorder);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0 , index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, len), Arrays.copyOfRange(postorder, index, len - 1));
        return root;
    }

    private int findIndex(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) return i;
        }
        return -1;
    }

    // 时间空间效率高
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int len = postorder.length;
        return recur(inorder, postorder, 0, len - 1, len - 1);
    }

    public TreeNode recur(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i; break;
            }
        }
        root.left = recur(inorder, postorder, inStart, index - 1, postEnd - 1 - (inEnd - index));
        root.right = recur(inorder, postorder, index + 1, inEnd, postEnd - 1);
        return root;
    }
}
