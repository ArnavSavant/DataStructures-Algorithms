import java.util.ArrayList;
import java.util.List;

public class Leetcode_1382 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        TreeNode newRoot = balance(inOrder, 0, inOrder.size() - 1);
        return newRoot;
    }

    public void inOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

    public TreeNode balance(List<Integer> inOrder, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = high - (high - low) / 2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = balance(inOrder, low, mid);
        root.right = balance(inOrder, mid + 1, high);

        return root;
    }
}
