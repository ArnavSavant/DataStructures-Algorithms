public class FloorInBST {
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int Floor(BinaryTreeNode node, int input) {
        if (node == null) {
            return -1;
        }
        int ans = -1;
        while (node != null) {
            if (node.data == input) {
                return input;
            } else if (node.data > input) {
                node = node.left;
            } else if (node.data <= input) {
                ans = node.data;
                node = node.right;
            }
        }
        return ans;
    }
}
