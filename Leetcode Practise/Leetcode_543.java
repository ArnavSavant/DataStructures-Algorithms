public class Leetcode_543 {
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

    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }

    public int maxDepth(TreeNode root, int diameter[]) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left, diameter);
        int rightMax = maxDepth(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}
/*
### Documentation for the `diameterOfBinaryTree` Method

#### Overview

The `diameterOfBinaryTree` method calculates the diameter of a binary tree. The diameter of a tree is defined as the length of the longest path between any two nodes in the tree. This path may or may not pass through the root. The length of the path is represented by the number of edges between the nodes.

#### Algorithm

1. **Initialize Diameter**: An integer array `diameter` of size 1 is used to store the diameter of the tree. This allows the `maxDepth` helper function to modify the diameter across recursive calls.

2. **Calculate Maximum Depth and Update Diameter**:
   - The `maxDepth` function is recursively called on the root node, with `diameter` passed as an argument.
   - For each node `root`, the function calculates the maximum depth of its left and right subtrees (`leftMax` and `rightMax`, respectively).
   - It then updates the diameter if the sum of `leftMax` and `rightMax` is greater than the current diameter. This sum represents the longest path that passes through `root`.
   - The function returns the depth of the tree rooted at `root`, which is 1 plus the maximum of `leftMax` and `rightMax`.

#### Why It Works

This method works by leveraging the relationship between the diameter of a tree and the depth of its subtrees. For any node, the longest path that passes through it is equal to the sum of the maximum depths of its left and right subtrees. By calculating these depths and updating the maximum seen so far at each node, the method ensures that the final diameter is the length of the longest path in the tree.

#### Time and Space Complexity

- **Time Complexity**: O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once to calculate its maximum depth, and hence, the overall time complexity is linear with respect to the size of the tree.

- **Space Complexity**: O(h), where h is the height of the binary tree. The space complexity is determined by the height of the recursion stack, which, in the worst case (a skewed tree), could be O(n), but for a balanced tree, it would be O(log n).

#### Summary

The `diameterOfBinaryTree` method efficiently calculates the diameter of a binary tree using a depth-first search approach. By recursively finding the maximum depth of subtrees and updating the diameter at each node, this method ensures accurate calculation of the tree's diameter, considering the longest path between any two nodes. The use of a single-element array to track the diameter allows for easy updating and retrieval of the diameter across recursive calls.
 */