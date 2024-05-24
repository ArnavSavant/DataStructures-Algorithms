import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_623 {
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        depth--;
        while (!queue.isEmpty()) {
            if (depth == 1) {
                while (queue.size() > 0) {
                    TreeNode temp = queue.poll();
                    TreeNode tempLeft = temp.left;
                    TreeNode tempRight = temp.right;
                    temp.left = new TreeNode(val);
                    temp.right = new TreeNode(val);
                    if (tempLeft != null) {
                        temp.left.left = tempLeft;
                    }
                    if (tempRight != null) {
                        temp.right.right = tempRight;
                    }
                }
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            depth--;
        }
        return root;
    }
}
