import java.util.Stack;

public class IterativeInOrder {
    TreeNode root;

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(4);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(6);
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(3);
        TreeNode sixth = new TreeNode(5);
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
    public void iterativeInOrder(TreeNode root) {
        System.out.println("IN ORDER TRAVERSAL");

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + "  ");
                temp = temp.right;
            }
        }
    }

    public static void main(String[] args) {
        IterativeInOrder obj = new IterativeInOrder();
        obj.createBinaryTree();
        obj.iterativeInOrder(obj.root);

    }
}
