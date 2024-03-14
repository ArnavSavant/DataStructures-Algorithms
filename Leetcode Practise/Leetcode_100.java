public class Leetcode_100 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverseTree(p, q);
    }

    public boolean traverseTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!traverseTree(p.left, q.left) || !traverseTree(p.right, q.right)) {
            return false;
        }
        return true;
    }
}
/*
 * The provided code defines a method to compare two binary trees (`p` and `q`)
 * and determine if they are structurally identical and have the same node
 * values in the corresponding positions. This is a classic problem in computer
 * science, often solved using recursion due to the hierarchical nature of
 * trees. Let's break down the code to understand how it accomplishes this task.
 * 
 * ### TreeNode Class
 * 
 * The `TreeNode` class is a basic structure for representing a node in a binary
 * tree, containing:
 * - `val` (int): The integer value stored in the node.
 * - `left` (TreeNode): A reference to the left child node.
 * - `right` (TreeNode): A reference to the right child node.
 * 
 * The class provides constructors for creating a node with no children, a node
 * with a specific value, and a node with a value and references to its left and
 * right children.
 * 
 * ### isSameTree Method
 * 
 * The `isSameTree` method is the public interface that takes two `TreeNode`
 * objects, `p` and `q`, as inputs and returns a boolean indicating whether the
 * two trees are identical. It simply calls the `traverseTree` method with `p`
 * and `q` as arguments.
 * 
 * ### traverseTree Method
 * 
 * The `traverseTree` method is the core of the algorithm. It recursively
 * compares the nodes of the two trees to verify if they are the same. The
 * method's logic can be broken down as follows:
 * 
 * 1. **Base Cases**:
 * - If both `p` and `q` are `null`, it means we have reached the end of both
 * trees simultaneously. In this case, the trees are identical up to this point,
 * so it returns `true`.
 * - If one of `p` or `q` is `null` (but not both), it means the trees diverge
 * (one has more levels or branches than the other), so it returns `false`.
 * 
 * 2. **Value Comparison**:
 * - If the values of the current nodes in both trees (`p.val` and `q.val`) do
 * not match, the trees are not identical, so it returns `false`.
 * 
 * 3. **Recursive Calls**:
 * - The method then makes recursive calls to itself for both the left and right
 * children of the current nodes (`p.left` with `q.left` and `p.right` with
 * `q.right`). If either of these recursive calls returns `false`, indicating a
 * mismatch in any part of the subtree, the method returns `false`.
 * 
 * 4. **Success Case**:
 * - If the method has not returned `false` through any of the above checks, it
 * means all corresponding nodes in the two trees matched, and it returns
 * `true`.
 * 
 * ### Logic and Intuition
 * 
 * The approach is based on the idea that two trees are identical if and only if
 * their root values are the same, and their respective left and right subtrees
 * are also identical. This recursive definition naturally leads to a recursive
 * algorithm that checks each node pair one by one from the root down to the
 * leaves.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(n), where n is the minimum number of nodes in the
 * two trees. In the worst case, the algorithm must visit every node in both
 * trees once before it can determine that they are identical or find a
 * discrepancy.
 * 
 * - **Space Complexity**: O(h), where h is the height of the tree. This space
 * is used by the call stack during recursion. In the worst case (a completely
 * unbalanced tree), the height of the tree could be n, leading to a space
 * complexity of O(n). For a balanced tree, the height h would be log(n),
 * resulting in a space complexity of O(log n).
 * 
 * The `isSameTree` method effectively uses recursive depth-first traversal to
 * compare two binary trees for structural and value equality, leveraging the
 * stack space for recursive calls.
 */