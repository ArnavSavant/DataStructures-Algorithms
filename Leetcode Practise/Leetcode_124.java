public class Leetcode_124 {
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

    public int maxPathSum(TreeNode root) {
        int maxSum[] = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        int x = findPathSum(root, maxSum);
        maxSum[0] = Math.max(x, maxSum[0]);
        return maxSum[0];
    }

    public int findMax(int num1, int num2, int num3, int num4, int num5) {
        int max = num1;
        max = Math.max(max, num2);
        max = Math.max(max, num3);
        max = Math.max(max, num4);
        max = Math.max(max, num5);
        return max;
    }

    public int findPathSum(TreeNode root, int maxSum[]) {
        if (root == null) {
            return 0;
        }
        int leftSum = findPathSum(root.left, maxSum);
        int rightSum = findPathSum(root.right, maxSum);
        int s1 = root.val + leftSum + rightSum;
        int s2 = root.val + leftSum;
        int s3 = root.val + rightSum;
        maxSum[0] = findMax(s1, s2, s3, root.val, maxSum[0]);
        return Math.max(root.val, root.val + Math.max(leftSum, rightSum));
    }
}

/*
The code you've provided is a Java method designed to find the maximum path sum in a binary tree. Let's break down each part of the code for a comprehensive understanding.

### Overview
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. The path sum of a path is the sum of the node values in the path.

### Method: `maxPathSum(TreeNode root)`

#### Parameters
- `root`: The root node of the binary tree.

#### Logic
1. **Initialization**: An array `maxSum` of size 1 is created, with its only element initialized to `Integer.MIN_VALUE`. This array will hold the maximum path sum found in the tree.
2. **Finding Path Sum**: The method `findPathSum` is called with the root node and the `maxSum` array. This method traverses the tree and updates `maxSum[0]` with the maximum path sum.
3. **Finalizing Maximum Sum**: The value returned by `findPathSum` is compared with `maxSum[0]`, and the maximum of these two is set as the final max path sum.

#### Complexity
- The complexity is O(N), where N is the number of nodes in the tree. This is because the algorithm traverses each node exactly once.

### Method: `findMax(int num1, int num2, int num3, int num4, int num5)`

#### Parameters
- `num1`, `num2`, `num3`, `num4`, `num5`: Five integer values among which the maximum is to be found.

#### Logic
- This method simply finds the maximum of the five given integers.

#### Complexity
- The complexity is O(1), constant time, as it only involves a fixed number of comparisons.

### Method: `findPathSum(TreeNode root, int maxSum[])`

#### Parameters
- `root`: The current node in the binary tree.
- `maxSum`: An array of size 1 to store the maximum path sum.

#### Logic
1. **Base Case**: If the current node is `null`, it returns 0, as there is no contribution to the path sum.
2. **Recursive Calls**: It recursively calls itself for the left and right children of the current node, storing the sums in `leftSum` and `rightSum`, respectively.
3. **Path Sum Calculations**: It calculates the sum of paths including the current node in various combinations:
   - `s1`: Current node value + left path sum + right path sum.
   - `s2`: Current node value + left path sum.
   - `s3`: Current node value + right path sum.
4. **Updating Maximum Path Sum**: The `maxSum[0]` is updated to the maximum of `s1`, `s2`, `s3`, the current node's value, and the previous maximum.
5. **Return Value**: It returns the maximum path sum that can be obtained by including the current node, either just the node itself or the node plus the maximum of the left or right path sums.

#### Complexity
- The complexity is O(N) as it involves traversing each node once.

### Intuition and Why it Works
- The main intuition behind this code is to consider all possible path sums at each node (including the node alone, the node with left path, the node with right path, and the node with both paths) and update the maximum sum found so far.
- The use of an array (`maxSum`) to store the maximum sum is a common technique in Java to allow updating values inside recursive calls.
- By considering all possible path combinations at each node and updating the maximum, the algorithm ensures that the maximum path sum in the entire tree is found.

Overall, the code is an efficient way to solve the maximum path sum problem in a binary tree, utilizing recursion and careful updates of a global maximum.
the given code for finding the maximum path sum in a binary tree is optimized in terms of time complexity. Here's why:

Single Pass Through the Tree: The algorithm traverses each node exactly once. During each visit to a node, it calculates the maximum path sums considering various combinations (node only, node with left subtree, node with right subtree, and node with both subtrees). This ensures that all possible path sums involving each node are considered without the need for re-traversing any part of the tree.

Global Maximum Tracking: By using an array (maxSum) to keep track of the global maximum path sum, the algorithm avoids the need for additional data structures or complex return types that could complicate the recursion. The use of an array is a common Java technique to mimic pass-by-reference behavior, allowing the recursive method to update the maximum value found so far.

Efficient Space Usage: The space complexity is mainly due to the recursive call stack, which in the worst case (for a skewed tree) can be O(N), where N is the number of nodes in the tree. However, for a balanced tree, the height (and thus the maximum depth of recursion) would be O(log N), making the space usage quite efficient.

No Redundant Computations: The algorithm does not perform any redundant computations. Each node's value is used exactly once to calculate the path sums, and the results of these calculations are directly used to update the global maximum without re-calculating any path sums.
 */
