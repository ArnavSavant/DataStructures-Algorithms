import java.util.Stack;

public class Leetcode_173 {
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

    class BSTIterator {

        TreeNode root;
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            this.root = root;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode temp = stack.pop();
            int ans = temp.val;
            
            temp = temp.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            return ans;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
/*
 * This code implements an iterator for a binary search tree (BST) that returns
 * the elements in the BST in ascending order. The key components involved in
 * this implementation include a TreeNode class to represent the nodes of the
 * tree and a BSTIterator class that implements the iterator functionality.
 * Let's dive into the details:
 * 
 * ### TreeNode Class
 * - `val`: The value stored in the node.
 * - `left`: Reference to the left child node.
 * - `right`: Reference to the right child node.
 * - Constructors are provided for creating nodes with different sets of initial
 * values and child nodes.
 * 
 * ### BSTIterator Class
 * This class is designed to iterate over the nodes of a binary search tree in
 * an in-order sequence, which naturally produces the values in ascending order
 * for a BST.
 * 
 * - **Member Variables**:
 * - `root`: Stores the root of the BST. However, after closer inspection, it
 * appears that this member is unnecessary since the current state of iteration
 * is maintained entirely using the `stack` and not directly dependent on `root`
 * after initialization.
 * - `stack`: A stack used to manage the traversal state. It helps backtrack to
 * the next node to be visited after completing the left subtree of any node.
 * 
 * - **Constructor** (`public BSTIterator(TreeNode root)`):
 * - Initializes the iterator starting at the root of the BST.
 * - The constructor iteratively traverses to the leftmost node from the root,
 * pushing all the nodes encountered along the path onto the stack. This process
 * prepares the stack for the `next()` operation by ensuring that the smallest
 * element is at the top of the stack, ready to be accessed.
 * 
 * - **next() Method**:
 * - Pops the top element from the stack, which represents the next smallest
 * element in the BST due to the way the stack was initialized and is managed.
 * - It then moves to the right child of the popped node (if any) and follows
 * all its left children, pushing them onto the stack. This step ensures that
 * after returning the current smallest element, the stack is prepared for the
 * next call to `next()`, with the next smallest element at the top.
 * - Returns the value of the node that was popped off the stack.
 * 
 * - **hasNext() Method**:
 * - Simply checks if the stack is empty. If the stack is not empty, it means
 * there are more nodes to visit; otherwise, the iteration is complete.
 * 
 * ### Why This Code Works
 * The logic closely follows the in-order traversal pattern but does so
 * iteratively instead of recursively. By leveraging a stack, the iterator can
 * pause and resume the traversal, yielding control back to the caller after
 * each element is accessed, which fits the iterator pattern perfectly.
 * 
 * ### Complexity Analysis
 * - **Time Complexity**:
 * - `next()`: Amortized O(1). Although finding the next element involves
 * traversing to the leftmost child of the right subtree, each node gets pushed
 * and popped from the stack exactly once across all calls to `next()`.
 * - `hasNext()`: O(1), as it only checks if the stack is empty.
 * - **Space Complexity**: O(H), where H is the height of the tree. This space
 * is used by the stack to maintain the state of the iteration. In the worst
 * case (a degenerate tree), the space complexity could be O(N), where N is the
 * number of nodes in the tree. For a balanced tree, the space complexity would
 * be O(log N).
 * 
 * This implementation is efficient and works well for in-order traversal of a
 * BST, providing access to elements in sorted order on-demand without needing
 * to store all elements in memory simultaneously.
 */