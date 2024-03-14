public class Leetcode_230 {
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

    public int kthSmallest(TreeNode root, int k) {
        int x[] = { 0 };
        int ans[] = new int[1];
        inOrder(root, k, x, ans);
        return ans[0];
    }

    public void inOrder(TreeNode root, int k, int x[], int ans[]) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k, x, ans);
        x[0] = x[0] + 1;
        if (x[0] == k) {
            ans[0] = root.val;
            return;
        }
        inOrder(root.right, k, x, ans);
    }
}
/*
 * This code snippet is designed to find the k-th smallest element in a binary
 * search tree (BST). It leverages the property of BSTs where the in-order
 * traversal yields the elements in sorted order. The `TreeNode` class defines
 * the structure of each node in the BST, including the node's value (`val`),
 * and pointers to its left and right children.
 * 
 * ### Key Components
 * 
 * - **TreeNode Class**: Defines the structure of a node in the BST.
 * - **kthSmallest Method**: This is the public method that initiates the
 * process to find the k-th smallest element. It utilizes an in-order traversal
 * to achieve this.
 * - **inOrder Method**: A helper method that recursively performs an in-order
 * traversal of the BST and keeps track of the count of visited nodes to
 * identify the k-th smallest element.
 * 
 * ### Logic and Intuition
 * 
 * The intuition behind this approach is based on the characteristic of BSTs
 * where an in-order traversal visits the nodes in ascending order. By
 * performing an in-order traversal, we can count each node as we visit it. When
 * the count reaches `k`, we've found the k-th smallest element.
 * 
 * - **In-Order Traversal**: The in-order traversal visits the left subtree,
 * then the current node, and finally the right subtree. This ensures that nodes
 * are visited in non-decreasing order.
 * - **Count Tracking**: The count of visited nodes is tracked using an array
 * `x[]` with a single element. Arrays are used instead of primitive data types
 * for their ability to be passed by reference, allowing the recursive calls to
 * share and update the same count.
 * - **Stopping Condition**: When the count (`x[0]`) matches `k`, the current
 * node's value (`root.val`) is the k-th smallest element. This value is stored
 * in another single-element array `ans[]` to capture the result across
 * recursive calls.
 * 
 * ### Detailed Breakdown
 * 
 * 1. **Base Case**: If `root` is null, the function returns immediately,
 * handling cases of empty trees or reaching the end of a branch.
 * 2. **Left Subtree**: Recursively visit the left subtree. This step explores
 * all smaller elements first.
 * 3. **Visit Node**: Increment the count of visited nodes (`x[0]`). If the
 * count equals `k`, store the current node's value in `ans[0]` and return to
 * halt further traversal.
 * 4. **Right Subtree**: If the k-th smallest hasn't been found yet, continue by
 * visiting the right subtree.
 * 
 * ### Why This Code Works
 * 
 * The code effectively utilizes the sorted nature of in-order traversal in a
 * BST to identify the k-th smallest element. The use of arrays for tracking the
 * count and the answer allows the recursive calls to modify these values across
 * different levels of recursion, ensuring that the state is maintained
 * correctly throughout the execution.
 * 
 * ### Complexities
 * 
 * - **Time Complexity**: O(N) in the worst case, where N is the number of nodes
 * in the tree. Although the algorithm might stop early once the k-th smallest
 * element is found, in the worst-case scenario (where k equals N), it traverses
 * the entire tree.
 * - **Space Complexity**: O(H) for the recursive stack, where H is the height
 * of the tree. This could be O(log N) in a balanced tree but O(N) in the worst
 * case for a skewed tree. The space used by the `x[]` and `ans[]` arrays is
 * constant, O(1).
 */