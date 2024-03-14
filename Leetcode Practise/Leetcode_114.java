public class Leetcode_114 {
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

    public void flatten(TreeNode root) {
        solve(root);
    }

    public TreeNode solve(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightNode = root.right;
        TreeNode leftRightestNode = solve(root.left);
        TreeNode rightRightestNode = solve(root.right);
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            leftRightestNode.right = rightNode;
        }
        if (leftRightestNode == null && rightRightestNode == null) {
            return root;
        }
        return rightRightestNode != null ? rightRightestNode : leftRightestNode;
    }
}
/*
### Documentation for the `flatten` Method

#### Logic of the Code

The `flatten` method transforms a binary tree into a "flattened" tree where each node's right child points to the next node of a pre-order traversal, effectively turning the tree into a linked list that follows the original tree's left boundaries. This transformation is done in place, altering the original tree structure. The method employs a recursive strategy encapsulated in the `solve` function to:

1. **Base Case Handling**: If the current node (`root`) is `null`, the recursion returns `null`, indicating there's no further tree structure to process.

2. **Recursive Flattening**: The method recursively flattens the left and right subtrees. This process ensures that each subtree is processed into a linear chain of nodes according to pre-order traversal rules before any restructuring.

3. **Reconnecting Nodes**:
   - The right subtree of the current node (`root`) is temporarily saved (`rightNode`).
   - The last node of the flattened left subtree (`leftRightestNode`) is obtained.
   - The last node of the flattened right subtree (`rightRightestNode`) is obtained.
   - If the current node has a left child, the method attaches the flattened left subtree as the right child of the current node (since the tree is being flattened to the right), clears the current node's left pointer, and then connects the previously saved right subtree to the end of the newly attached left subtree.

4. **Determining the Rightmost Node**: The method returns the rightmost node of the current subtree to the previous recursion level, which is necessary for connecting subsequent nodes correctly. This node is determined by checking the availability of the rightmost nodes in the right and left subtrees.

#### Intuition to Develop This Logic/Approach

The intuition behind this approach is leveraging the properties of pre-order traversal (root, left, right) to sequentially arrange the nodes. By recursively flattening the left and right subtrees first and then reattaching them to the right of the current node, the method adheres to the pre-order pattern while ensuring that each node's right pointer leads to the next node in the sequence. This strategy simplifies the complex tree restructuring by breaking it down into manageable steps that respect the original tree's traversal order.

#### Why This Code Works

This code effectively transforms the binary tree into a flattened structure because it systematically processes and rearranges each subtree according to the pre-order traversal logic. By ensuring that each node's left subtree is reattached to its right and that the original right subtree follows this newly attached chain, the method maintains the correct node sequence. The recursive design facilitates handling each subtree independently before integrating them into a single flattened structure, ensuring the integrity of the pre-order sequence.

#### Time and Space Complexities

- **Time Complexity**: The time complexity is O(n), where n is the number of nodes in the tree. Each node is visited exactly once during the recursion, ensuring that the entire tree is processed efficiently.

- **Space Complexity**: The space complexity is O(h), where h is the height of the tree. This space is used by the call stack during the recursion. In the worst case (a skewed tree), this complexity could be O(n), but for a balanced tree, it would be O(log n).

The `flatten` method offers an efficient and intuitive solution for transforming a binary tree into a flattened structure that follows the pre-order traversal order, leveraging recursion to simplify the process of reattaching subtrees in a linear fashion.
 */