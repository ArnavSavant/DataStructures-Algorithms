public class Leetcode_98 {

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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validate(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    public boolean validate(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        boolean leftResult = validate(root.left, lower, root.val);
        boolean rightResult = validate(root.right, root.val, upper);

        return leftResult && rightResult;
    }
}
/*
 * The provided code is an attempt to validate if a binary tree is a Binary
 * Search Tree (BST). However, it has a significant logical flaw that can lead
 * to incorrect results in certain cases. Let's break down the code, explain its
 * intention, identify the flaw, and then discuss the correct approach and its
 * complexities.
 * 
 * ### Code Explanation
 * 
 * 1. **TreeNode Class**: This class represents the structure of each node in
 * the binary tree, containing an integer value `val`, and pointers to the left
 * and right child nodes.
 * 
 * 2. **isValidBST Method**: This method is intended to check if a binary tree
 * rooted at `root` is a valid Binary Search Tree. The properties of a BST that
 * it aims to validate are:
 * - Every node's value to the left of a given node must be strictly less than
 * the node's value.
 * - Every node's value to the right of a given node must be strictly greater
 * than the node's value.
 * - Both the left and right subtrees themselves must also be valid BSTs.
 * 
 * ### Logical Flaw
 * 
 * The approach taken in `isValidBST` checks the immediate left and right
 * children of the current node to ensure they satisfy the BST conditions
 * relative to the current node. However, it doesn't correctly enforce that
 * **all** nodes in the left subtree must be less than the current node's value
 * and that **all** nodes in the right subtree must be greater than the current
 * node's value. This means that while the immediate children might satisfy the
 * BST property, nodes further down might not, but this code would still
 * incorrectly return `true`.
 * 
 * For example, consider a tree where the root node has a value of 10, the left
 * child has a value of 5, and the right child of the left child has a value of
 * 12. This tree would incorrectly be considered a BST by this code because it
 * does not properly compare the value of 12 against the root node's value.
 * 
 * ### Correct Approach
 * 
 * To correctly implement `isValidBST`, one must check not just the immediate
 * children, but all nodes in each subtree. A common approach is to use
 * recursion with additional parameters that maintain the allowable range of
 * values for each subtree. Here's a brief outline of how it can be done:
 * 
 * ```java
 * public boolean isValidBST(TreeNode root) {
 * return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
 * }
 * 
 * private boolean validate(TreeNode node, long lower, long upper) {
 * if (node == null) {
 * return true;
 * }
 * if (node.val <= lower || node.val >= upper) {
 * return false;
 * }
 * return validate(node.left, lower, node.val) && validate(node.right, node.val,
 * upper);
 * }
 * ```
 * 
 * In this correct approach, `validate` is called recursively for each subtree,
 * narrowing the valid range of values each time. For the left subtree, the
 * upper bound becomes the current node's value, and for the right subtree, the
 * lower bound becomes the current node's value.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the tree. Each
 * node is visited exactly once, leading to a linear time complexity.
 * - **Space Complexity**: O(N) in the worst case (the tree is completely
 * unbalanced and resembles a linked list), due to the recursion stack. In the
 * best case (the tree is perfectly balanced), the space complexity would be
 * O(log N), corresponding to the height of the tree.
 * 
 * ### Conclusion
 * 
 * The original code snippet attempts a simplistic approach to validate a BST
 * but fails due to not considering the entire subtree for each validation step.
 * The correct approach involves a more thorough validation using a helper
 * function that checks every node against a dynamically updated range of valid
 * values, ensuring that the BST properties are maintained throughout the entire
 * tree.
 */
