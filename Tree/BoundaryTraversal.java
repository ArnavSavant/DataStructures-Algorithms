import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public static void recursiveInOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        recursiveInOrder(root.left, ans);
        if (root.left == null && root.right == null) {
            ans.add(root.data);
        }
        recursiveInOrder(root.right, ans);
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.data);
        TreeNode temp = root.left;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                break;
            }
            ans.add(temp.data);
            if (temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        recursiveInOrder(root, ans);
        
        Stack<Integer> stack = new Stack<>();
        temp = root.right;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                break;
            }
            stack.add(temp.data);
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}