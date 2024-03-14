import java.util.HashMap;
import java.util.Map;

public class Leetcode_106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, mp);
        return root;
    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> mp) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = mp.get(root.val);
        int numsLeft = inEnd - index;

        root.left = buildTree(postorder, postStart, postEnd - numsLeft - 1, inorder, inStart, index - 1, mp);
        root.right = buildTree(postorder, postEnd - numsLeft, postEnd - 1, inorder, index + 1, inEnd, mp);
        return root;

    }
}
/*
 * The provided code is an implementation of a binary tree construction
 * algorithm, given two arrays representing the tree's inorder and postorder
 * traversals. This task is a classic problem in computer science, particularly
 * in the context of binary tree algorithms. The logic behind the solution is
 * rooted in understanding how inorder and postorder traversals represent the
 * structure of a binary tree.
 * 
 * ### Understanding the Problem
 * 
 * A binary tree can be uniquely reconstructed given its inorder and postorder
 * traversals, assuming all the values in the tree are unique. The inorder
 * traversal visits nodes in the order: left child, root, right child. The
 * postorder traversal visits nodes in the order: left child, right child, root.
 * 
 * ### Key Intuition
 * 
 * 1. **Root Identification**: In postorder, the last element is always the root
 * of the current tree or subtree being considered. This root splits the inorder
 * array into left and right subtrees.
 * 2. **Subtree Construction**: Once the root is identified and the inorder
 * array is split, the left and right subtrees can recursively be constructed by
 * applying the same logic.
 * 
 * ### Detailed Logic
 * 
 * - **Mapping Inorder Indices**: The code first creates a hashmap (`mp`)
 * mapping each value in the inorder array to its index. This allows for O(1)
 * access to find the root position in the inorder array, which is critical for
 * determining the boundaries of the left and right subtrees.
 * 
 * - **Recursive Tree Construction**: The `buildTree` method is called
 * recursively to construct the tree. It uses the following parameters:
 * - `postorder`, `inorder`: The given postorder and inorder traversal arrays.
 * - `postStart`, `postEnd`: The start and end indices for the current subtree
 * in the postorder array.
 * - `inStart`, `inEnd`: The start and end indices for the current subtree in
 * the inorder array.
 * - `mp`: The hashmap for finding the index of the root in the inorder array
 * quickly.
 * 
 * - **Base Case**: If `postStart` > `postEnd` or `inStart` > `inEnd`, it means
 * the subtree is empty, so it returns `null`.
 * 
 * - **Root Creation**: The root of the current subtree is identified as the
 * last element in the current postorder segment. A new `TreeNode` is created
 * with this value.
 * 
 * - **Finding Subtrees**:
 * - The root's index in the inorder array is found using the hashmap.
 * - The number of nodes in the right subtree is calculated by `inEnd - index`.
 * - This information is used to recursively construct the left and right
 * subtrees. The key observation is that the postorder segment corresponding to
 * the left subtree is always before the segment for the right subtree, and
 * knowing the size of the right subtree (`numsLeft`) allows calculating the
 * exact boundaries for the left and right subtrees in the postorder array.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(n). Each element's index lookup in the inorder array
 * is O(1) due to the hashmap, and each element in both arrays is processed
 * exactly once. Thus, the overall time complexity is linear in terms of the
 * number of nodes, n, in the tree.
 * 
 * - **Space Complexity**: O(n). The hashmap requires O(n) space to store the
 * index of each value in the inorder array. The recursion stack also uses
 * space, which in the worst case, could be O(n) for a skewed tree, but
 * typically it's O(log n) for a balanced tree. Therefore, the total space
 * complexity is O(n) considering the hashmap and the worst-case recursion
 * depth.
 * 
 * ### Conclusion
 * 
 * The algorithm leverages the properties of inorder and postorder traversals to
 * reconstruct the binary tree by identifying the root from postorder traversal
 * and using it to divide the inorder array into left and right subtrees. This
 * division guides the recursive construction of the entire tree. The use of a
 * hashmap for index lookup is a key optimization that ensures the solution
 * remains efficient.
 */