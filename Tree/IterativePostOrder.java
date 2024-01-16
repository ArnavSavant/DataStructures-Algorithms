import java.util.Stack;

public class IterativePostOrder {
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

    public void iterativePostOrder(TreeNode root) {
        System.out.println("POST ORDER TRAVERSAL");
        if (root == null) {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + "  ");
                    while (!stack.isEmpty() && (temp == stack.peek().right)) {
                        temp = stack.pop();
                        System.out.print(temp.data + "  ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        IterativePostOrder obj = new IterativePostOrder();
        obj.createBinaryTree();
        obj.iterativePostOrder(obj.root);
    }
}
