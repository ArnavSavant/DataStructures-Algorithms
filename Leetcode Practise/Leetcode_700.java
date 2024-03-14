public class Leetcode_700 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
/*
### Documentation for the `searchBST` Method

#### Overview

The `searchBST` method searches for a node within a Binary Search Tree (BST) that contains a specific value (`val`). If such a node is found, the method returns the node; otherwise, it returns `null`. This method efficiently navigates the BST leveraging its sorted property—values to the left of a node are less than the node's value, and values to the right are greater.

#### Algorithm

1. **Check for Null Root**: If the initial root is `null`, indicating an empty tree, the method immediately returns `null`, as the value cannot be found.

2. **Iterative Search**:
   - The method enters a while loop that continues as long as the current node (`root`) is not `null`.
   - At each iteration, it compares the current node's value with the target value (`val`):
     - **Equal to `val`**: If the current node's value is equal to `val`, the search is successful, and the current node is returned.
     - **Less than `val`**: If the current node's value is less than `val`, the method continues the search to the right subtree.
     - **Greater than `val`**: If the current node's value is greater than `val`, the method continues the search to the left subtree.

3. **Return Null**: If the loop exits without finding the target value, it means the value is not present in the BST, and the method returns `null`.

#### Why It Works

This method takes advantage of the BST's inherent structure, where each node ensures that all values in its left subtree are lesser and all values in its right subtree are greater. By comparing the target value against the current node's value at each step, the method efficiently narrows down the search area, quickly converging on the target node or determining its absence.

#### Time Complexity

- **O(h)**, where `h` is the height of the BST. In the worst-case scenario (a skewed BST), the height of the tree can be `n` (the number of nodes), leading to a time complexity of O(n). For a balanced BST, the height of the tree is approximately `log(n)`, leading to a more efficient search time of O(log n).

#### Space Complexity

- **O(1)**, as the search operation is performed iteratively without utilizing additional data structures that scale with the size of the input tree. The space used is constant, regardless of the number of nodes in the BST.

#### Summary

The `searchBST` method provides an efficient and straightforward approach to finding a specific value within a BST. By leveraging the sorted property of BSTs, it ensures a fast and space-efficient search process, making it an effective solution for lookup operations in binary search trees.
 */