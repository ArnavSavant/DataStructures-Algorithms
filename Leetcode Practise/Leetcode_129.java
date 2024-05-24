public class Leetcode_129 {
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

    public int sumNumbers(TreeNode root) {
        int sum[] = new int[1];
        sum[0] = 0;
        solve(root, sum, root.val);
        return sum[0];
    }

    public void solve(TreeNode root, int[] sum, int num) {
        if (root.left == null && root.right == null) {
            sum[0] = sum[0] + num;
            return;
        }

        if (root.left != null) {
            num = num * 10 + root.left.val;
            solve(root.left, sum, num);
            num = num / 10;
        }
        if (root.right != null) {
            num = num * 10 + root.right.val;
            solve(root.right, sum, num);
        }
    }
}
/*
The `sumNumbers` method is designed to calculate the sum of all numbers formed by the root-to-leaf paths in a binary tree where each node contains a single digit. The numbers are formed by appending each node's value from root to leaf. The provided code is mostly correct but could be slightly optimized and cleaned up for better understanding and efficiency. Let's review and improve the method:

### Overview of the Algorithm

1. **Recursive Helper Function (`solve`)**:
   - This function is called initially from `sumNumbers` with the root node, an array `sum` to keep track of the total sum, and the initial number formed by the root's value.
   - As it recursively traverses the tree, it builds numbers by appending the current node's value to a running total `num` multiplied by 10.
   - When a leaf node is reached (both `left` and `right` children are `null`), it adds the current number to the sum.

2. **Base Case**:
   - For a leaf node, add the number formed to the sum.
   - For non-leaf nodes, recursively call the function for non-null children, updating the number accordingly.

3. **Return Statement**:
   - After the recursive traversal completes, the total sum of all root-to-leaf numbers is stored in `sum[0]` and returned.

### Correction and Improvement

The logic to update the `num` variable within the `solve` function could be refined to avoid unnecessary multiplications and divisions which might lead to potential overflow or inaccuracies for very deep trees.

```java
public int sumNumbers(TreeNode root) {
    return sumNumbersHelper(root, 0);
}

private int sumNumbersHelper(TreeNode node, int currentSum) {
    if (node == null) {
        return 0;
    }

    currentSum = currentSum * 10 + node.val;

    // Check if it is a leaf node
    if (node.left == null && node.right == null) {
        return currentSum;
    }

    // Recursive call to both children and sum the results
    return sumNumbersHelper(node.left, currentSum) + sumNumbersHelper(node.right, currentSum);
}
```

### Explanation of Improvements

- **Eliminating Global State**: By passing the current sum as a parameter that gets updated and returned, the function avoids using an external array to track the sum, making it more self-contained and functional.
- **Direct Return**: This version directly returns the sum from the recursive calls, making it easier to understand and possibly more efficient since it doesn't require additional operations outside of the recursive logic.
- **Parameter Simplification**: The initial call now only needs the root and starts with a `currentSum` of 0, simplifying the initial setup.

### Complexity Analysis

- **Time Complexity**: Remains O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
- **Space Complexity**: Also remains O(h), where h is the height of the tree, corresponding to the depth of the recursive call stack. In a balanced tree, this would be O(log n), and in the worst case (a skewed tree), it could be O(n).

This refactored version of `sumNumbers` retains the original functionality but improves on clarity and potentially on performance by streamlining the parameter passing and avoiding the use of a mutable array for sum aggregation.
 */