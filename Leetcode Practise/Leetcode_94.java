import java.util.ArrayList;
import java.util.List;

public class Leetcode_94 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
/*
 * The given code defines a simple binary tree structure and implements an
 * in-order traversal of the tree, returning the values of the nodes in their
 * in-order sequence. Let's break down the code into its components and
 * understand each part:
 * 
 * ### TreeNode Class
 * 
 * The `TreeNode` class is a standard representation of a node in a binary tree,
 * where each node contains:
 * - `val` (int): The value stored in the node.
 * - `left` (TreeNode): A reference to the left child node.
 * - `right` (TreeNode): A reference to the right child node.
 * 
 * There are three constructors provided:
 * 1. A default constructor that initializes an empty node.
 * 2. A constructor that initializes a node with a given value and null
 * references for its children.
 * 3. A constructor that initializes a node with a value and references to its
 * left and right children.
 * 
 * ### inorderTraversal Method
 * 
 * The `inorderTraversal` method is the public method that users call to perform
 * an in-order traversal of a binary tree starting from a given root node. It
 * initializes an empty list of integers (`ans`) to store the sequence of values
 * obtained from the traversal. It then calls a helper method `inOrder` with the
 * root node and the list as arguments. Finally, it returns the list filled with
 * the values of the nodes visited in in-order sequence.
 * 
 * ### inOrder Helper Method
 * 
 * The `inOrder` method is a recursive helper method designed to perform the
 * actual in-order traversal of the tree. The in-order traversal follows a
 * specific sequence:
 * 1. Visit the left subtree.
 * 2. Visit the root node.
 * 3. Visit the right subtree.
 * 
 * This method takes a `TreeNode` (the current node being visited) and a
 * `List<Integer>` (to accumulate the values of the nodes) as parameters. The
 * base case for the recursion is when the current node is `null`, in which case
 * the method returns immediately without doing anything. This condition
 * effectively handles the case of an empty tree or the leaf nodes' children.
 * 
 * If the current node is not `null`, the method recursively calls itself with
 * the left child of the current node, then adds the value of the current node
 * to the list, and finally, recursively calls itself with the right child of
 * the current node. This process ensures that the values are added to the list
 * in the exact in-order sequence.
 * 
 * ### Logic and Intuition
 * 
 * The intuition behind in-order traversal is that for any given node, all
 * values in the left subtree are visited and added to the list before the
 * node's value is added, and all values in the right subtree are visited and
 * added after. This traversal method is particularly useful in binary search
 * trees (BSTs) where in-order traversal retrieves values in their sorted order.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(n), where n is the number of nodes in the binary
 * tree. Each node is visited exactly once, resulting in a linear time
 * complexity relative to the size of the tree.
 * 
 * - **Space Complexity**: O(n) for the list that stores the traversal results.
 * In addition, the space complexity for the recursive call stack should also be
 * considered, which in the worst case (a completely unbalanced tree) can also
 * be O(n). However, for a balanced tree, the height (and thus the max depth of
 * recursive calls) would be log(n), resulting in a space complexity of O(log n)
 * for the call stack. Hence, the overall space complexity is O(n) considering
 * the output list and O(log n) to O(n) for the call stack, depending on the
 * tree's shape.
 * 
 * This implementation effectively demonstrates how to traverse a binary tree
 * in-order and collect its values using recursion, leveraging the call stack to
 * return to previous nodes and proceed to their right subtrees in sequence.
 */
