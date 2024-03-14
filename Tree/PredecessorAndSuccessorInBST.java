import java.util.ArrayList;
import java.util.List;

public class PredecessorAndSuccessorInBST {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        ans.add(predecessor(root, key));
        ans.add(successor(root, key));
        return ans;
    }

    public static int predecessor(TreeNode root, int key) {
        int predecessor = -1;
        while (root != null) {
            if (root.data < key) {
                predecessor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }

    public static int successor(TreeNode root, int key) {
        int successor = -1;
        while (root != null) {
            if (root.data <= key) {
                root = root.right;
            } else {
                successor = root.data;
                root = root.left;
            }
        }
        return successor;
    }
}
