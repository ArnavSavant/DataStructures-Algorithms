import java.util.Stack;

public class Leetcode_653 {
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

    public int next(Stack<TreeNode> stack) {
        TreeNode temp = stack.pop();
        int ans = temp.val;
        temp = temp.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return ans;
    }

    public int before(Stack<TreeNode> stack) {
        TreeNode temp = stack.pop();
        int ans = temp.val;
        temp = temp.left;
        while (temp != null) {
            stack.push(temp);
            temp = temp.right;
        }
        return ans;
    }

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode temp = root;
        while (root != null) {
            stack1.push(root);
            root = root.left;
        }
        while (temp != null) {
            stack2.push(temp);
            temp = temp.right;
        }
        int x1 = next(stack1);
        int x2 = before(stack2);
        while (x1 < x2) {
            if (x1 + x2 == k) {
                return true;
            } else if (x1 + x2 > k) {
                x2 = before(stack2);
            } else {
                x1 = next(stack1);
            }
        }
        return false;
    }
}
/*
### Documentation for the `findTarget` Method

#### Overview

The `findTarget` method aims to find if there exists two elements in a Binary Search Tree (BST) such that their sum equals a given target value `k`. The approach utilizes two stacks to perform an in-order traversal from both ends of the BST simultaneously—one stack for ascending order and the other for descending order—effectively scanning the BST for the two numbers from opposite ends.

#### Algorithm

1. **Initial Stack Preparation**:
   - Populate `stack1` for ascending order traversal by pushing all nodes along the leftmost path from the root.
   - Populate `stack2` for descending order traversal by pushing all nodes along the rightmost path from the root.

2. **Next and Before Functions**:
   - `next`: Pops the top of `stack1` and pushes all nodes along the leftmost path starting from the right child of the popped node, simulating in-order traversal.
   - `before`: Pops the top of `stack2` and pushes all nodes along the rightmost path starting from the left child of the popped node, simulating reverse in-order traversal.

3. **Finding the Target**:
   - Retrieve the next smallest element (`x1`) and the next largest element (`x2`) using `next` and `before`, respectively.
   - If `x1 + x2 == k`, return `true`.
   - If the sum is greater than `k`, move to the next smaller element by calling `before`.
   - If the sum is less than `k`, move to the next larger element by calling `next`.
   - Continue until `x1` is no longer less than `x2`. If no such pair is found, return `false`.

#### Why It Works

This method effectively utilizes the BST property, where in-order traversal yields elements in ascending order, and a modified reverse in-order traversal yields elements in descending order. By advancing from both ends towards the middle, it ensures that every possible pair is checked for the sum condition with respect to `k`, thus guaranteeing the identification of the pair if it exists.

#### Time and Space Complexity

- **Time Complexity**: O(n), where `n` is the number of nodes in the BST. In the worst case, the method might need to traverse the entire tree to find the target pair or conclude it doesn't exist.
- **Space Complexity**: O(h), where `h` is the height of the BST. The space complexity is governed by the stack size, which, in the worst case, is equal to the height of the tree due to the push of leftmost or rightmost path nodes. For a balanced tree, this is O(log n), but for a skewed tree, it could be O(n).

#### Summary

The `findTarget` method provides an efficient and elegant solution to determine if a BST contains two elements that sum up to a target value `k`. By leveraging the BST properties and conducting a two-end in-order traversal with stacks, it ensures a thorough and efficient search through the tree, offering a practical approach to solving the two-sum problem in the context of BSTs.
 */