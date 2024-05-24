public class Leetcode_988 {
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

    public String smallestFromLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return ((char) (root.val + 97)) + "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(((char) (root.val + 97)) + "");
        StringBuffer ans = new StringBuffer();
        dfs(root, ans, sb);
        return ans.toString();
    }

    public void dfs(TreeNode root, StringBuffer ans, StringBuffer sb) {
        if (root.left == null && root.right == null) {
            StringBuffer temp = new StringBuffer(sb.reverse());
            sb.reverse();
            if (ans.length() == 0 || temp.toString().compareTo(ans.toString()) < 0) {
                ans.setLength(0);
                ans.append(temp);
            }
            return;
        }
        if (root.left != null) {
            sb.append(((char) (root.left.val + 97)) + "");
            dfs(root.left, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            sb.append(((char) (root.right.val + 97)) + "");
            dfs(root.right, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
