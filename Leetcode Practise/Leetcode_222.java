public class Leetcode_222 {
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

    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1+ countNodes(root.left)+countNodes(root.right);
    }
}
/*
 * This code snippet is a straightforward implementation of a function to count
 * the total number of nodes in a binary tree. It defines a `TreeNode` class and
 * a method `countNodes` to calculate the total number of nodes in the tree
 * rooted at a given node. Let's break down the components and logic of this
 * code:
 * 
 * ### TreeNode Class
 * 
 * - `val`: Holds the integer value of the node.
 * - `left`: A reference to the left child node.
 * - `right`: A reference to the right child node.
 * - Constructors are provided to create a node without any children, a node
 * with a specific value, and a node with a specific value along with left and
 * right children.
 * 
 * ### countNodes Method
 * 
 * - The method `countNodes` takes a single parameter, `root`, which is a
 * reference to the root node of a binary tree (or subtree).
 * - **Base Case**: If `root` is `null`, indicating either the tree is empty or
 * it has reached beyond the leaf nodes, it returns 0. This base case is crucial
 * for terminating the recursion.
 * - **Recursive Case**: If `root` is not `null`, the method calculates the
 * total number of nodes by:
 * - Counting the current node as `1`.
 * - Recursively counting all nodes in the left subtree:
 * `countNodes(root.left)`.
 * - Recursively counting all nodes in the right subtree:
 * `countNodes(root.right)`.
 * - The total count for the current subtree rooted at `root` is the sum of the
 * counts from the left and right subtrees plus one for the current node. This
 * sum is returned as the result.
 * 
 * ### Why This Code Works
 * 
 * This code leverages the recursive nature of binary trees. By breaking down
 * the problem into smaller subproblems (i.e., counting nodes in the left and
 * right subtrees), it simplifies the process of counting all nodes in the tree.
 * The recursion bottoms out at leaf nodes' children, which are `null`, ensuring
 * that every node is counted exactly once and that the recursion terminates
 * properly.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the tree. This
 * is because the algorithm must visit each node exactly once to count it,
 * leading to a time complexity that is linear in the size of the tree.
 * - **Space Complexity**: O(H), where H is the height of the tree. The space
 * complexity is determined by the height of the recursion stack, which, in the
 * worst case, is equal to the height of the tree. For a perfectly balanced
 * binary tree, the height H would be log(N), making the space complexity
 * O(log(N)). However, in the worst case (a completely skewed tree), the height
 * can be as much as N, making the space complexity O(N).
 */