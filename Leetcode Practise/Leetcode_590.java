import java.util.ArrayList;
import java.util.List;

public class Leetcode_590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        solve(root, ans);
        return ans;
    }

    public void solve(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node children : root.children) {
                solve(children, ans);
            }
        }
        ans.add(root.val);
    }
}
