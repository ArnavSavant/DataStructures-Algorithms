public class Leetcode_450 {
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

    public TreeNode deleteRoot(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode leftChild = root.left;
        TreeNode temp = rightChild;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = leftChild;
        return rightChild;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            return deleteRoot(root);
        }
        TreeNode temp = root;
        TreeNode node = null;
        while (temp != null) {
            if (temp.left != null && temp.left.val == key) {
                node = temp.left;
                break;
            }
            if (temp.right != null && temp.right.val == key) {
                node = temp.right;
                break;
            }
            if (key < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (node == null) {
            return root;
        }
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;
        if (leftChild == null && rightChild == null) {
            if (key < temp.val) {
                temp.left = null;
            } else {
                temp.right = null;
            }
        } else if (leftChild == null) {
            if (key < temp.val) {
                temp.left = rightChild;
            } else {
                temp.right = rightChild;
            }
        } else if (rightChild == null) {
            if (key < temp.val) {
                temp.left = leftChild;
            } else {
                temp.right = leftChild;
            }
        } else {
            if (key < temp.val) {
                temp.left = rightChild;
            } else {
                temp.right = rightChild;
            }
            temp = rightChild;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = leftChild;
        }
        return root;
    }
}
/*
### Documentation for the `deleteNode` Method

#### Overview

The `deleteNode` method is designed to delete a node with a specific key from a binary search tree (BST) and adjust the tree to maintain the BST properties. The method employs a systematic approach to locate and remove the target node, ensuring the tree remains valid by appropriately reorganizing the remaining nodes.

#### Algorithm

1. **Base Case**: If the root is `null`, return `null` immediately, indicating the tree is empty or we've reached a leaf's child.

2. **Find and Delete the Root Node**: If the root itself matches the key, use the `deleteRoot` helper method to delete the root and reorganize the tree accordingly.

3. **Search for the Node**: Traverse the tree to find the node to be deleted (`node`) and its parent (`temp`). This is achieved by comparing the key with the current node's value to decide whether to move left or right in the tree.

4. **Node Deletion**: Once the target node is found, there are several cases for its deletion:
   - If the node is a leaf (no children), simply remove it by setting the respective child of its parent to `null`.
   - If the node has one child, replace it in its parent's child reference with its own child.
   - If the node has two children, replace it with its right child and reattach its left child to the leftmost leaf of the right subtree, ensuring the BST properties are preserved.

#### Why It Works

The `deleteNode` method effectively maintains the BST properties after deletion by ensuring that:
- For a node with no children, removal is straightforward.
- For a node with one child, the child takes its place, preserving the BST order.
- For a node with two children, replacing the node with its right child and reattaching the left child to the right child's leftmost leaf maintains the correct in-order sequence of values.

This approach guarantees that all nodes in the left subtree of any node `X` are less than `X`, and all nodes in the right subtree are greater than `X`, consistent with BST rules.

#### Time and Space Complexity

- **Time Complexity**: O(h), where `h` is the height of the tree. In the worst case, the node to be deleted is at the bottom of the tree, requiring a path traversal from the root to a leaf.
- **Space Complexity**: O(h) due to recursive stack space in the worst case for unbalanced trees. For balanced trees, this would be O(log n), where `n` is the number of nodes in the tree.

#### Summary

The `deleteNode` method offers a robust solution for deleting a node from a BST while preserving the BST properties. It handles all possible cases of node deletion, including nodes with no children, one child, or two children, ensuring the tree remains a valid BST after the operation.
 */