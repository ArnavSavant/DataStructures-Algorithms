import java.util.HashMap;
import java.util.Map;

public class Leetcode_105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, mp);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> mp) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = mp.get(root.val);
        int numsLeft = index - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, index - 1, mp);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, index + 1, inEnd, mp);
        return root;

    }
}
/*
 * The provided code is an elegant solution for constructing a binary tree from
 * its preorder and inorder traversal arrays. It leverages recursion and a
 * hashmap for efficient index lookups. Let's dissect the code, its underlying
 * logic, and intuition, and analyze why it works effectively, along with its
 * complexities.
 * 
 * ### Understanding the Inputs
 * 
 * - **Preorder Traversal** is a type of depth-first traversal where each node
 * is processed before its left and right children. The first element of the
 * preorder array is always the root of the tree.
 * - **Inorder Traversal** is another depth-first traversal where each node is
 * processed between its left and right children. This traversal results in
 * nodes being visited in ascending order if the tree is a binary search tree.
 * 
 * ### Logic and Intuition
 * 
 * The key to reconstructing the binary tree lies in understanding how these
 * traversals relate to the tree's structure:
 * 
 * 1. **Preorder's First Element as Root**: The first element in the preorder
 * array is the root of the binary tree.
 * 2. **Root Element in Inorder Array**: This divides the inorder array into two
 * parts; the left part represents the left subtree, and the right part
 * represents the right subtree.
 * 3. **Repeating the Process Recursively**: By applying the same logic
 * recursively, we can reconstruct the entire tree.
 * 
 * ### Detailed Explanation
 * 
 * 1. **HashMap for Inorder Indexes**: First, the function creates a hashmap
 * (`mp`) to store the indexes of elements in the inorder array. This allows for
 * O(1) lookups to find the root's index in the inorder array, which is crucial
 * for determining the boundaries of the left and right subtrees.
 * 
 * 2. **Recursive Tree Construction**: The `buildTree` recursive function is
 * called with the full preorder and inorder arrays, along with their respective
 * start and end indexes. On each recursive call:
 * - A new `TreeNode` is created with `preorder[preStart]` as its value since
 * the preorder's first element is always the root.
 * - The root element's index in the inorder array is found using the hashmap.
 * This index splits the inorder array into left and right subtrees.
 * - The number of elements in the left subtree is calculated (`numsLeft`),
 * which is used to determine the boundaries for further recursive calls for
 * left and right subtrees.
 * - Recursive calls are made to construct the left and right subtrees,
 * adjusting the `preStart`, `preEnd`, `inStart`, and `inEnd` indexes
 * accordingly.
 * 
 * ### Why This Code Works
 * 
 * This approach efficiently reconstructs the binary tree by always choosing the
 * correct root node from the preorder array and then finding the extent of its
 * left and right subtrees using the inorder array. The use of a hashmap for
 * quick index lookups significantly reduces the time complexity that would
 * otherwise be spent searching for indexes in the inorder array.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the tree. Each
 * node is processed exactly once when creating the TreeNode and placing it in
 * the correct position in the tree.
 * - **Space Complexity**: O(N), for storing the hashmap of inorder indexes. The
 * recursive call stack would also contribute to the space complexity, which in
 * the worst case (a skewed tree) could add another O(N), but typically, for a
 * balanced tree, it would be O(log N).
 * 
 * ### Conclusion
 * 
 * This code demonstrates an efficient method for reconstructing a binary tree
 * from preorder and inorder traversals. The combination of recursion for tree
 * construction and hashmap for quick index lookups provides an elegant and
 * efficient solution, adhering to O(N) time complexity.
 */
