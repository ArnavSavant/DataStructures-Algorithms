public class Leetcode_701 {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode temp = root;
        TreeNode parent = root;
        while (temp != null) {
            parent = temp;
            if (val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (parent.val > val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }
}
/*
The `insertIntoBST` method aims to insert a new node with a specific value into a Binary Search Tree (BST) while maintaining the BST properties. However, there's a logical error in the condition for attaching the new node to the `parent` node. Let's address the correct approach and implementation.

### Corrected Implementation

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    TreeNode temp = root;
    while (true) {
        if (val < temp.val) {
            if (temp.left == null) {
                temp.left = new TreeNode(val);
                break;
            } else {
                temp = temp.left;
            }
        } else {
            if (temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            } else {
                temp = temp.right;
            }
        }
    }
    return root;
}
```

### Explanation

1. **Handling Null Root**: If the root is `null`, a new node with the given value is created and returned as the new root of the BST.

2. **Traversal**: Starting from the root, the method traverses the tree to find the correct spot for the new value. This traversal maintains the BST property: left child < parent node < right child.

3. **Insertion**:
   - If the value is less than the current node's value and the left child is `null`, the new node is inserted as the left child.
   - If the value is greater or equal to the current node's value and the right child is `null`, the new node is inserted as the right child.

4. **Infinite Loop with Break Condition**: The loop continues until the correct insertion point is found. The use of `break` exits the loop once the new node is inserted.

### Correction in the Original Code

The original code mistakenly sets `parent.right` for values less than `parent.val` when it should set `parent.left` for lesser values and `parent.right` for greater or equal values. The corrected implementation above fixes this logic, ensuring the new node is inserted in the correct position according to BST rules.

### Time and Space Complexity

- **Time Complexity**: O(h), where h is the height of the BST. In the worst case, the new node is inserted at the leaf, which could be at the tree's height.
  
- **Space Complexity**: O(1), as the insertion is done iteratively and does not use additional space proportional to the size or height of the tree.
 */