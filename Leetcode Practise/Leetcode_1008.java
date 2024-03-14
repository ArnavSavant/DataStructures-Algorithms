import java.util.Stack;

public class Leetcode_1008 {
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

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (node.val < stack.peek().val) {
                stack.peek().left = node;
                stack.add(node);
            } else {
                TreeNode temp = null;
                while (!stack.isEmpty() && stack.peek().val < node.val) {
                    temp = stack.pop();
                }
                temp.right = node;
                stack.push(node);
            }
        }
        return root;
    }
}
/*
 * ### Documentation for the `bstFromPreorder` Method
 * 
 * #### Logic of the Code
 * 
 * The `bstFromPreorder` method constructs a binary search tree (BST) from a
 * given array of integers representing the preorder traversal of the BST. The
 * method uses a stack to maintain the path from the root to the current node,
 * enabling efficient tree construction with the following steps:
 * 
 * 1. **Initialization**: The root of the BST is initialized with the first
 * element of the preorder array.
 * 2. **Traversal and Construction**: The method iterates through the preorder
 * array starting from the second element. For each element:
 * - A new node is created.
 * - If the value of the new node is less than the value of the top node in the
 * stack, it means the new node is the left child of the top node. The new node
 * is then added to the stack.
 * - If the value of the new node is greater than the value of the top node in
 * the stack, the method pops nodes from the stack until it finds a node with a
 * value less than the new node's value, indicating that the new node is the
 * right child of the last popped node. The new node is then added to the stack.
 * 3. **Stack Maintenance**: The stack helps maintain the current path in the
 * BST, ensuring nodes are correctly assigned as left or right children based on
 * their values.
 * 
 * #### Intuition to Develop This Logic/Approach
 * 
 * The intuition behind using a stack is rooted in the properties of preorder
 * traversal in a BST:
 * - The first value is always the root.
 * - Values less than a node's value must be in its left subtree, and values
 * greater must be in its right subtree.
 * - A stack can efficiently track the path from the root to the current node,
 * allowing for quick determination of each new node's correct position in the
 * BST.
 * 
 * Using a stack facilitates backtracking to the correct parent node to attach
 * new nodes in their appropriate positions, closely mimicking the recursive
 * nature of tree construction but in an iterative manner.
 * 
 * #### Why This Code Works
 * 
 * This code works effectively for constructing a BST from its preorder
 * traversal because:
 * - **Correct Node Placement**: It correctly identifies the position of each
 * new node by comparing it with the nodes in the current path (maintained in
 * the stack), ensuring adherence to BST properties.
 * - **Efficient Path Tracking**: The stack enables efficient backtracking to
 * the last node that the new node can be attached to as a right child, if
 * necessary.
 * - **Handling Left and Right Children**: By comparing the new node's value
 * with the stack's top node value, it accurately determines whether the new
 * node should be a left or right child, ensuring the BST's structural
 * integrity.
 * 
 * #### Time and Space Complexities
 * 
 * - **Time Complexity**: The time complexity of this method is O(n), where n is
 * the number of nodes in the preorder traversal. Each node is processed exactly
 * once, with stack operations (push and pop) having O(1) complexity.
 * 
 * - **Space Complexity**: The space complexity is O(h), where h is the height
 * of the tree. In the worst case (a skewed tree), this could be O(n). However,
 * for a balanced tree, this would be O(log n). The space complexity accounts
 * for the stack used to maintain the path from the root to the current node.
 * 
 * The `bstFromPreorder` method provides an efficient and intuitive way to
 * reconstruct a BST from its preorder traversal, leveraging a stack to
 * dynamically track the tree's construction path and ensure correct node
 * placement.
 */