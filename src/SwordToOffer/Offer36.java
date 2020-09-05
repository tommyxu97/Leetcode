package SwordToOffer;

/*
// Definition for a SwordToOffer.Node.
class SwordToOffer.Node {
    public int val;
    public SwordToOffer.Node left;
    public SwordToOffer.Node right;

    public SwordToOffer.Node() {}

    public SwordToOffer.Node(int _val) {
        val = _val;
    }

    public SwordToOffer.Node(int _val,SwordToOffer.Node _left,SwordToOffer.Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
public class Offer36 {

    private Node pre, head;

    // 中序遍历
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void recur(Node node) {
        if (node == null) return;
        recur(node.left);
        if (pre == null) head = node;
        else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        recur(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
