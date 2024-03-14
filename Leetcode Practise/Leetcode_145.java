import java.util.ArrayList;
import java.util.List;

public class Leetcode_145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
/*
 * This code snippet is designed to perform a post-order traversal of a binary
 * tree and collect the values of its nodes into a list. A binary tree is a data
 * structure where each node has at most two children, referred to as the left
 * child and the right child. The `TreeNode` class defines the structure of each
 * node in the binary tree. Let's break down the components and logic of this
 * code:
 * 
 * ### TreeNode Class
 * 
 * - `val`: An integer value stored in the node.
 * - `left`: A reference to the left child of the node.
 * - `right`: A reference to the right child of the node.
 * - Constructors are provided for creating nodes with different sets of initial
 * values and child nodes.
 * 
 * ### postorderTraversal Method
 * 
 * - This method is the entry point for the traversal. It initializes an empty
 * list `ans` that will eventually contain the values of the nodes in
 * post-order.
 * - It calls a helper method `postOrder` with the root of the tree and the list
 * `ans`.
 * - Finally, it returns the list `ans`.
 * 
 * ### postOrder Helper Method
 * 
 * - This recursive method performs the actual post-order traversal and fills
 * the list with the node values.
 * - **Base Case**: If the current node (`root`) is null, it simply returns
 * without doing anything. This handles the cases of empty trees or leaves'
 * children.
 * - **Recursive Calls**: It first recursively visits the left subtree
 * (`postOrder(root.left, list)`), then the right subtree
 * (`postOrder(root.right, list)`).
 * - **Visit Node**: After visiting both subtrees, it adds the current node's
 * value to the list (`list.add(root.val)`). This is the key step that makes it
 * a post-order traversal: a node is processed after its subtrees.
 * 
 * ### Post-order Traversal Logic
 * 
 * Post-order traversal follows the pattern of visiting the left subtree, then
 * the right subtree, and finally the node itself. This order is particularly
 * useful in scenarios where operations on a node depend on the results from its
 * subtrees, such as when freeing memory used by the tree or evaluating postfix
 * expressions.
 * 
 * ### Why This Code Works
 * 
 * The code works because it adheres to the recursive definition of a post-order
 * traversal. By handling the base case of a null node, it gracefully handles
 * all possible tree structures, including empty trees and leaf nodes. The
 * recursive structure ensures that each node and its subtrees are visited in
 * the correct order, and the use of a list to collect the node values allows
 * for easy aggregation and return of the traversal results.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the tree. Each
 * node is visited exactly once, making the traversal linear in the number of
 * nodes.
 * - **Space Complexity**: O(N) for the output list that contains the node
 * values. Additionally, the space complexity for the recursive call stack is
 * O(H), where H is the height of the tree. In the worst case (a skewed tree), H
 * can be O(N), making the total space complexity O(N). In the best case (a
 * balanced tree), H is O(log N), but since the output list's size dominates for
 * large N, the overall space complexity remains O(N).
 */