public class ChildSumProperty {
    class Node {
        public int data;
        public Node left;
        public Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isParentSum(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftVal = 0;
        int rightVal = 0;
        if (root.left != null) {
            leftVal = root.left.data;
        }
        if (root.right != null) {
            rightVal = root.right.data;
        }
        if (root.data != (leftVal + rightVal)) {
            return false;
        }
        boolean leftResult = true;
        boolean rightResult = true;
        if (root.left != null) {
            leftResult = isParentSum(root.left);
        }
        if (root.right != null) {
            rightResult = isParentSum(root.right);
        }
        return leftResult && rightResult;
    }
}
