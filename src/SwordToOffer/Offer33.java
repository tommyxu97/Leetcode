package SwordToOffer;

public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    // 递归
    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int index = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, index - 1) && recur(postorder, index, j - 1);
    }
}
