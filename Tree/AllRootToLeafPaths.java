import java.util.List;
import java.util.ArrayList;

public class AllRootToLeafPaths {
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(BinaryTreeNode root, List<String> ans, StringBuffer sb) {
        int lengthBeforeAppend = sb.length();
        sb.append(root.data).append(" ");

        if (root.left == null && root.right == null) {
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
        } else {

            if (root.left != null) {
                preorder(root.left, ans, sb);
            }
            if (root.right != null) {
                preorder(root.right, ans, sb);
            }
        }
        sb.setLength(lengthBeforeAppend);
    }

    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> ans = new ArrayList<String>();
        preorder(root, ans, new StringBuffer());
        return ans;
    }
}
