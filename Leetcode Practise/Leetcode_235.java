public class Leetcode_235 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val || (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if (leftResult != null && rightResult != null) {
            return root;
        }
        if(leftResult==null) {
            return rightResult;
        }
        else {
            return leftResult;
        }
    }
}
/*
### Documentation for the `lowestCommonAncestor` Method

#### Logic of the Code

The `lowestCommonAncestor` method is designed to find the lowest common ancestor (LCA) of two nodes in a binary tree. The LCA of two nodes `p` and `q` is defined as the deepest node in the tree that has both `p` and `q` as descendants (where a node can be a descendant of itself). The method employs a recursive approach to traverse the tree and identify the LCA based on the following logic:

1. **Base Case**: If the current node (`root`) is `null`, return `null`, indicating that the LCA is not found in the current path.

2. **Direct Match**: If the current node matches either `p` or `q`, return the current node. This signifies that the current node is either `p`, `q`, or their LCA.

3. **Recursive Descent**: Recursively search for `p` and `q` in the left and right subtrees:
   - `leftResult`: The result of searching the left subtree for `p` and `q`.
   - `rightResult`: The result of searching the right subtree for `p` and `q`.

4. **Decision Making**:
   - If both `leftResult` and `rightResult` are non-null, it means one of the nodes `p` or `q` was found in each subtree, making the current node their LCA.
   - If only one of `leftResult` or `rightResult` is non-null, return the non-null result, indicating that both `p` and `q` are located in one subtree, and the LCA is the result of that subtree's search.
   - If both are `null`, return `null`, indicating that neither `p` nor `q` was found in the current subtree.

#### Intuition to Develop This Logic/Approach

The intuition behind this recursive approach is that the LCA of two nodes in a binary tree is the node that is able to "capture" the paths to both nodes within its subtree. By recursively searching the tree starting from the root, we can identify the point at which the paths to `p` and `q` diverge. This point of divergence, where both nodes are found in different subtrees of a node, is the LCA.

#### Why This Code Works

This code works effectively for identifying the LCA because it leverages the recursive nature of tree structures to simplify the problem into manageable subproblems—namely, identifying if `p`, `q`, or both are present in any given subtree rooted at a node. By returning early when either `p` or `q` is found, it minimizes unnecessary computation. Furthermore, by checking both subtrees before making a decision, it ensures that all possibilities are considered, thus accurately identifying the LCA based on the placement of `p` and `q` within the tree.

#### Time and Space Complexities

- **Time Complexity**: O(n), where n is the number of nodes in the binary tree. In the worst case, the algorithm might visit all nodes if the LCA is near the bottom of the tree or if `p` and `q` are in separate subtrees that require full traversal.

- **Space Complexity**: O(h), where h is the height of the binary tree. This space complexity accounts for the recursive call stack. In the worst case (a skewed tree), the space complexity could also be O(n) due to the depth of the recursion matching the height of the tree.

### Summary

The `lowestCommonAncestor` method provides a robust and efficient solution to the common problem of finding the lowest common ancestor of two nodes in a binary tree, utilizing a recursive approach that leverages the properties of tree structures to simplify and solve the problem accurately.
 */