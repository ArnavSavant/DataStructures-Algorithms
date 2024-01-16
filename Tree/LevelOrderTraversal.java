import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + "  ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();
        obj.createBinaryTree();
        obj.levelOrderTraversal(root);
    }
}
