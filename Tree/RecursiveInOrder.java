public class RecursiveInOrder {
    static TreeNode root;

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        root = first; // null<----root---->null
        first.left = second; // second<----root---->null
        first.right = third; // second<----root---->third
        second.left = fourth; // fourth<----second---->null
        second.right = fifth; // fourth<----second---->fifth
        third.left = sixth; // sixth<----third---->null
        third.right = seventh; // sixth<----third---->seventh
    }

    // IN-ORDER TRAVERSAL
    // traverse the left subtree in order fashion
    // visit the root node
    // traverse the right subtree in order fashion
    public void recursiveInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveInOrder(root.left);
        System.out.print(root.data + "  ");
        recursiveInOrder(root.right);
    }

    public static void main(String[] args) {
        RecursiveInOrder obj = new RecursiveInOrder();
        obj.createBinaryTree();
        obj.recursiveInOrder(root);

    }
}
