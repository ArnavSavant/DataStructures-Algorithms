public class Leetcode_236 {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.data == p.data || root.data == q.data) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if (leftResult != null && rightResult != null) {
            return root;
        } else {
            if (leftResult == null) {
                return rightResult;
            } else {
                return leftResult;
            }
        }
    }
}
/*
The provided code defines a method `lowestCommonAncestor` within a context that includes a `TreeNode` class definition. This method is designed to find the lowest common ancestor (LCA) of two given nodes, `p` and `q`, in a binary tree. The LCA is the lowest node in the tree that has both `p` and `q` as descendants (where a node can be a descendant of itself).

### Explanation of the `lowestCommonAncestor` Method

#### Approach:
The method follows a recursive approach to solve the problem:
1. **Base Condition**: If the current node (`root`) is `null`, the method returns `null`, indicating that the current subtree does not contain either `p` or `q`.

2. **Direct Match**: If the current node matches either `p` or `q`, it returns the current node. This indicates that one of the targets has been found, and the current node could potentially be the LCA if the other target is in its subtree.

3. **Recursive Search**:
   - It recursively searches for `p` and `q` in the left and right subtrees of the current node.
   - `leftResult` stores the result of the search in the left subtree, and `rightResult` stores the result of the search in the right subtree.

4. **Decision Logic**:
   - If both `leftResult` and `rightResult` are not `null`, it means `p` and `q` are found in different subtrees of the current node. Therefore, the current node is their LCA.
   - If one of the results is `null`, the LCA is in the subtree that returned a non-null result. The method returns this non-null result.
   - If both are `null`, the current subtree does not contain either `p` or `q`, and thus it returns `null`.

#### Why It Works:
This method effectively identifies the LCA by leveraging the recursive structure of binary trees. By checking both subtrees and considering the cases where `p` and `q` are found in either or both subtrees, it ensures that the correct LCA is returned. The recursion naturally navigates through the tree's structure, propagating the findings upward until the LCA is determined.

### Time and Space Complexity

- **Time Complexity**: The time complexity is O(n), where n is the number of nodes in the binary tree. In the worst case, the method might need to visit every node in the tree once to find `p` and `q`.

- **Space Complexity**: The space complexity is O(h), where h is the height of the binary tree. This space is used by the call stack due to recursion. In the worst case (a skewed tree), this complexity could become O(n), where n is the number of nodes in the tree.

This method provides an efficient and intuitive solution to find the lowest common ancestor of two nodes in a binary tree, utilizing a recursive depth-first search strategy.
 */