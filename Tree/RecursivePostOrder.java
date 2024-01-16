public class RecursivePostOrder {
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

    // POST-ORDER TRAVERSAL
    // traverse the left subtree in order fashion
    // traverse the right subtree in order fashion
    // visit the root node
    public void recursivePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.data + "  ");
    }

    public static void main(String[] args) {
        RecursivePostOrder obj = new RecursivePostOrder();
        obj.createBinaryTree();
        obj.recursivePostOrder(root);

    }
}
