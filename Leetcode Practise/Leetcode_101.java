public class Leetcode_101 {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        boolean ans1 = compare(leftNode.left, rightNode.right);
        boolean ans2 = compare(leftNode.right, rightNode.left);

        return ans1 && ans2;
    }
}
/*
 * The code you've provided is designed to determine whether a binary tree is
 * symmetric around its center, essentially checking if the tree is a mirror
 * image of itself. This task is a common problem in computer science, testing
 * the understanding of tree data structures and recursion. Let's break down how
 * this code works, its logic, and analyze its complexities.
 * 
 * ### Code Structure
 * 
 * 1. **TreeNode Class**: This represents a node in the binary tree with an
 * integer value (`val`) and pointers to the left and right child nodes (`left`
 * and `right`). Constructors are provided for different initialization
 * scenarios.
 * 
 * 2. **isSymmetric Method**: This is the entry point for checking if the tree
 * rooted at `root` is symmetric. It handles the edge case where the tree is
 * empty (thus symmetric by definition) and then delegates the detailed
 * comparison to a helper method `compare` for the left and right subtrees of
 * the root.
 * 
 * 3. **compare Method**: This recursive method takes two nodes (`leftNode` and
 * `rightNode`) and checks if they are mirror images of each other. The
 * comparison involves checking:
 * - **Base Cases**:
 * - Both nodes are null, in which case the method returns true because null
 * trees are considered symmetric.
 * - One node is null and the other is not, in which case the method returns
 * false because their structures differ.
 * - **Value Comparison**: The values of `leftNode` and `rightNode` are
 * compared. If they are not equal, the method returns false.
 * - **Recursive Calls**: The method then makes two recursive calls:
 * - One to compare `leftNode.left` with `rightNode.right`.
 * - Another to compare `leftNode.right` with `rightNode.left`.
 * The results of these recursive calls must both be true for the subtree rooted
 * at `leftNode` and `rightNode` to be considered symmetric.
 * 
 * ### Logic and Intuition
 * 
 * The core intuition behind this approach is the definition of a symmetric
 * tree: a tree is symmetric if the left subtree is a mirror reflection of the
 * right subtree. This property must hold at every node, not just the root. The
 * recursive `compare` method applies this logic at each level, checking mirror
 * symmetry between corresponding nodes in the left and right subtrees.
 * 
 * ### Why This Code Works
 * 
 * This code effectively decomposes the problem into smaller subproblems by
 * using recursion. At each step, it checks if the current nodes being compared
 * are symmetric and then applies the same logic to their respective child
 * nodes. By applying these checks recursively, the code ensures that the
 * symmetry property is verified throughout the entire tree structure.
 * 
 * ### Complexities
 * 
 * - **Time Complexity**: O(n), where n is the number of nodes in the tree. In
 * the worst case, the algorithm must visit each node once to compare values and
 * structure, leading to a linear time complexity relative to the size of the
 * tree.
 * 
 * - **Space Complexity**: The space complexity is primarily determined by the
 * depth of the recursion stack, which, in the worst case, can be O(n) for a
 * completely unbalanced tree. However, for a balanced tree, the height (and
 * thus the maximum depth of the recursion stack) would be log(n), making the
 * space complexity O(log(n)) in the best case. This space is used to store the
 * call stack during the recursive calls.
 * 
 * ### Conclusion
 * 
 * The `isSymmetric` method and its helper `compare` effectively solve the
 * problem of checking tree symmetry by leveraging recursive comparisons across
 * mirror positions in the tree. This approach is both intuitive and efficient,
 * making it a standard solution for symmetry checks in binary trees.
 */
