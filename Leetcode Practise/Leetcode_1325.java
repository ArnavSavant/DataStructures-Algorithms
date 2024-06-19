public class Leetcode_1325 {
    class TreeNode {

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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    public TreeNode dfs(TreeNode root, int target) {
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        if (root.left != null) {
            root.left = dfs(root.left, target);
        }
        if (root.right != null) {
            root.right = dfs(root.right, target);
        }

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
