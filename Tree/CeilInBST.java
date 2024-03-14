public class CeilInBST {
    class TreeNode<T> {
        public T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static int findCeil(TreeNode<Integer> node, int x) {
        if (node == null) {
            return -1;
        }
        int ans = -1;
        while (node != null) {
            if (node.data == x) {
                return x;
            } else if (node.data < x) {
                node = node.right;
            } else if (node.data >= x) {
                ans = node.data;
                node = node.left;
            }
        }
        return ans;
    }
}
