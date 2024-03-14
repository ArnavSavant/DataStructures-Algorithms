import java.util.ArrayList;
import java.util.List;

public class Leetcode_144 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
/*
 * The provided code snippet is a Java implementation for performing a preorder
 * traversal on a binary tree and collecting the values of the nodes in the
 * traversal order. Before delving into the details of how it works, let's
 * clarify the key components and the preorder traversal process.
 * 
 * ### Key Components
 * 
 * 1. **TreeNode Class**: Represents a node in a binary tree with an integer
 * value (`val`) and references to its left and right child nodes.
 * 
 * 2. **preorderTraversal Method**: Initiates the preorder traversal from the
 * root of the tree.
 * 
 * 3. **preOrder Method (Recursive Helper)**: Performs the actual preorder
 * traversal in a recursive manner, collecting the node values.
 * 
 * ### Preorder Traversal Process
 * 
 * Preorder traversal is one of the depth-first search (DFS) strategies for
 * traversing or searching tree data structures. In preorder traversal, the
 * nodes are visited in the following order:
 * 1. **Visit the root node**.
 * 2. **Recursively traverse the left subtree**.
 * 3. **Recursively traverse the right subtree**.
 * 
 * This traversal method is called "preorder" because the root node is processed
 * before (pre) its subtrees.
 * 
 * ### How the Code Works
 * 
 * - When `preorderTraversal` is called with the root of the binary tree, it
 * initializes an empty list `ans` that will store the values of the nodes in
 * their preorder traversal order.
 * 
 * - The `preOrder` method is then called with the root node and the list. The
 * base case for the recursion is when `root` is `null`, at which point the
 * method returns immediately, doing nothing. This handles the case of empty
 * trees or reaching the leaves of the tree.
 * 
 * - If the current node (`root`) is not `null`, its value is added to `list`.
 * This is the "visit" step of the preorder process.
 * 
 * - The method then recursively calls itself first with the left child
 * (`preOrder(root.left, list)`) and then with the right child
 * (`preOrder(root.right, list)`), adhering to the preorder traversal order.
 * 
 * - This process continues until all nodes have been visited and their values
 * added to `list`. Finally, `ans` is returned to the caller.
 * 
 * ### Intuition and Logic
 * 
 * The intuition behind the recursive approach is to leverage the call stack to
 * remember the nodes to visit next after completing the current path. By
 * visiting the root first and then proceeding down the left and right subtrees,
 * we ensure that each node is processed in the preorder sequence.
 * 
 * ### Complexities
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the tree. Each
 * node is visited exactly once, making the time complexity linear in the size
 * of the tree.
 * 
 * - **Space Complexity**: O(N) in the worst case, which occurs in the case of a
 * skewed tree (where the tree is more like a linked list). This space is taken
 * up by the recursion stack. In the best case, where the tree is perfectly
 * balanced, the height of the tree would be log(N), and the space complexity
 * would be O(log(N)) due to the height of the recursion stack.
 * 
 * ### Conclusion
 * 
 * The provided code effectively performs a preorder traversal of a binary tree
 * using a recursive approach. It leverages the call stack to backtrack to
 * previous nodes and proceed to the right subtrees after left subtrees are
 * processed, thus ensuring that all nodes are visited in the correct order.
 * This method is straightforward and elegantly captures the essence of preorder
 * traversal using recursion.
 */