public class Leetcode_104 {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = 1 + maxDepth(root.left);
        int rightMax = 1 + maxDepth(root.right);

        return Math.max(leftMax, rightMax);
    }
}
/*
This piece of code is a Java method named `maxDepth` designed to calculate the maximum depth of a binary tree. Let's break down the code, its logic, intuition, and complexities in detail.

### Code Structure

1. **Method Signature**: `public int maxDepth(TreeNode root)`.
   - `public`: The method is publicly accessible.
   - `int`: The return type of the method, indicating it returns an integer.
   - `maxDepth`: Name of the method.
   - `TreeNode root`: The method takes a single argument `root` which is of type `TreeNode`. This represents the root node of a binary tree.

2. **Base Case Check**: `if (root == null) { return 0; }`.
   - This is a base case for the recursive method. If the current node (`root`) is `null`, it signifies the end of a branch or an empty tree. In this scenario, the depth is 0.

3. **Recursive Calls**:
   - `int leftMax = 1 + maxDepth(root.left);`
   - `int rightMax = 1 + maxDepth(root.right);`.
   - These lines recursively call the `maxDepth` method for the left and right children of the current node, respectively.
   - `1 +`: This part adds 1 to the depth count for the current level of the tree.

4. **Return Statement**: `return Math.max(leftMax, rightMax);`.
   - This line computes the maximum depth between the left and right subtrees and returns it.

### Logic and Intuition

The logic of this method is based on the concept of tree traversal in a depth-first manner. The depth of a tree is the length of the path from the root node to the deepest leaf node. The method uses a recursive approach to traverse the tree. At each node, it checks the depth of its left and right subtrees. Since a non-null node contributes 1 to the depth, each recursive call adds 1. The base case ensures that the recursion stops when it reaches a leaf node (whose children are `null`).

### Why This Code Works

1. **Recursive Approach**: The method works effectively because binary trees are naturally recursive structures. Each subtree of a binary tree is itself a binary tree.

2. **Handling Edge Cases**: The base case (`root == null`) correctly handles the edge case of an empty tree or the end of a branch.

3. **Combining Results**: By taking the maximum of the left and right depths, the method correctly computes the overall maximum depth of the tree.

### Time Complexity

- The time complexity of this method is O(N), where N is the number of nodes in the tree. This is because the method visits each node exactly once during the traversal.

### Space Complexity

- The space complexity is O(H), where H is the height of the tree. This accounts for the maximum size of the stack due to recursive calls. In the worst case (a skewed tree), the space complexity can become O(N), but for a balanced tree, it's much less.

### Conclusion

In summary, the `maxDepth` method is a well-designed function to determine the maximum depth of a binary tree using a depth-first recursive approach. Its effectiveness lies in its simplicity and adherence to the properties of a binary tree. The method handles all cases, including empty trees, and efficiently computes the depth by exploring each path to the leaf nodes.
 */

