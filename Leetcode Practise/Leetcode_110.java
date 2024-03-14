public class Leetcode_110 {
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

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) == -1 ? false : true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        if (leftMax == -1 || rightMax == -1) {
            return -1;
        }
        if (Math.abs(leftMax - rightMax) > 1) {
            return -1;
        }
        return Math.max(leftMax, rightMax) + 1;
    }
}
/*
 * This code defines a method to determine whether a binary tree is balanced. A
 * balanced binary tree, in this context, is defined as a tree in which the
 * depth of the two subtrees of every node never differs by more than one. The
 * code uses a bottom-up approach to efficiently solve the problem by combining
 * the height calculation and balance check in a single traversal.
 * 
 * ### TreeNode Class
 * 
 * - `TreeNode` is a simple class representing the nodes of a binary tree. Each
 * node contains an integer value (`val`) and references to its left and right
 * children (`left` and `right`).
 * 
 * ### isBalanced Method
 * 
 * - `isBalanced(TreeNode root)`: This is the main method that takes the root of
 * a binary tree and returns `true` if the tree is balanced and `false`
 * otherwise. It uses the helper method `maxDepth` to perform its task.
 * - Instead of directly returning a boolean, it checks if the result from
 * `maxDepth` is `-1`. If so, it means the tree is not balanced; otherwise, it
 * is.
 * 
 * ### maxDepth Method
 * 
 * - `maxDepth(TreeNode root)`: This recursive helper method calculates the
 * maximum depth of a tree. However, it is designed with a twist to serve a dual
 * purpose: it also checks for balance and returns `-1` if an imbalance is
 * detected at any point in the tree.
 * - Base Case: If the current node (`root`) is `null`, it returns `0`,
 * indicating that the height of an empty tree is zero.
 * - Recursive Calls: It recursively calculates the maximum depth of the left
 * and right subtrees.
 * - Early Termination: If either subtree is found to be imbalanced (indicated
 * by a return value of `-1`), `maxDepth` immediately returns `-1` to propagate
 * the imbalance detection upwards without further unnecessary calculations.
 * - Balance Check: After obtaining the maximum depths of both subtrees, it
 * checks if their difference is greater than `1`. If so, it returns `-1` to
 * indicate imbalance.
 * - Normal Return: If the subtree rooted at `root` is balanced, it returns the
 * maximum depth of the tree rooted at `root`, which is `1 + Math.max(leftMax,
 * rightMax)`.
 * 
 * ### Logic and Intuition
 * 
 * The intuition behind this approach is to perform the necessary work in a
 * single pass through the tree. By integrating the balance check into the depth
 * calculation, the algorithm avoids redundant traversals, making it efficient.
 * When an imbalance is detected, the method short-circuits and propagates the
 * failure state (`-1`) up the call stack, ensuring that no further unnecessary
 * work is done.
 * 
 * ### Why This Code Works
 * 
 * This code works effectively because it leverages the depth-first traversal
 * mechanism to check each subtree's balance as it calculates its depth. The use
 * of `-1` as a sentinel value to indicate imbalance allows the method to
 * simultaneously check for balance and calculate depth, fulfilling both
 * requirements with minimal overhead.
 * 
 * ### Complexities
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the tree. Each
 * node is visited once, and for each visit, the algorithm does a constant
 * amount of work.
 * - **Space Complexity**: O(H), where H is the height of the tree. This space
 * is used by the recursion stack. In the worst case (the tree is completely
 * unbalanced), H can be as large as N, making the space complexity O(N). In the
 * best case (the tree is perfectly balanced), the height of the tree is log(N),
 * making the space complexity O(log(N)).
 * 
 * ### Conclusion
 * 
 * The provided code is an efficient solution for checking if a binary tree is
 * balanced. It cleverly combines depth calculation with balance checking to
 * minimize traversal and utilizes a sentinel value to quickly propagate
 * imbalance detection up the tree.
 */