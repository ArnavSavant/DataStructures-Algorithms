import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Leetcode_103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root != null) {
            stack1.push(root);
        }
        int level = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            if (level % 2 == 1) {
                while (!stack1.isEmpty()) {
                    TreeNode curr = stack1.pop();
                    if (curr.left != null) {
                        stack2.push(curr.left);
                    }
                    if (curr.right != null) {
                        stack2.push(curr.right);
                    }
                    temp.add(curr.val);
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode curr = stack2.pop();
                    if (curr.right != null) {
                        stack1.push(curr.right);
                    }
                    if (curr.left != null) {
                        stack1.push(curr.left);
                    }
                    temp.add(curr.val);
                }
            }
            ans.add(temp);
            level++;
        }
        return ans;
    }
}
/*
 * ### Documentation for the `zigzagLevelOrder` Method
 * 
 * #### Logic of the Code
 * 
 * The `zigzagLevelOrder` method performs a zigzag (or spiral) level order
 * traversal on a binary tree and returns the values of the nodes in a list of
 * lists. The method uses two stacks (`stack1` and `stack2`) to alternate
 * between levels and to reverse the order of traversal at each level. Here's
 * how it works:
 * 
 * 1. **Initialization**: If the root is not `null`, it is pushed onto `stack1`.
 * The `level` variable is used to track whether the current level is odd or
 * even, determining the traversal direction.
 * 
 * 2. **Traversal**:
 * - On odd levels (1, 3, 5, ...), nodes are popped from `stack1`, and their
 * children are pushed onto `stack2`. Left children are pushed before right
 * children to ensure that right children are processed first in the next even
 * level, maintaining the zigzag order.
 * - On even levels (2, 4, 6, ...), nodes are popped from `stack2`, and their
 * children are pushed onto `stack1`. Right children are pushed before left
 * children so that left children are processed first in the next odd level.
 * 
 * 3. **Level Processing**: Each level's nodes are collected into a temporary
 * list (`temp`) as they are popped from the stack. After all nodes at the
 * current level are processed, `temp` is added to the answer list (`ans`).
 * 
 * 4. **Level Alternation**: The `level` variable is incremented after each
 * level is processed, ensuring the alternation between odd and even levels.
 * 
 * #### Intuition to Develop This Logic/Approach
 * 
 * The zigzag traversal requires alternating the direction of level traversal
 * between successive levels. Using two stacks naturally fits this requirement
 * because:
 * - Stacks reverse the order of their elements when popped, which aligns with
 * the zigzag pattern's need to reverse traversal direction at each level.
 * - Alternating between two stacks allows for the simultaneous preparation of
 * the next level in reverse order while the current level is being processed.
 * 
 * This method efficiently implements the zigzag pattern without needing to
 * reverse lists or use complex conditional logic to determine node processing
 * order.
 * 
 * #### Why This Code Works
 * 
 * This code effectively implements zigzag level order traversal due to its
 * structured use of two stacks to alternate traversal directions at each level.
 * By leveraging the LIFO (Last In, First Out) nature of stacks and alternating
 * between them for each level, it naturally achieves the zigzag pattern. This
 * approach ensures that each level's nodes are visited in the correct order and
 * that the traversal direction flips at each level.
 * 
 * #### Time and Space Complexities
 * 
 * - **Time Complexity**: The time complexity is O(n), where n is the number of
 * nodes in the tree. Each node is processed exactly once, regardless of the
 * zigzag pattern.
 * 
 * - **Space Complexity**: The space complexity is O(w), where w is the maximum
 * width of the tree. In the worst case, this could be up to O(n/2) = O(n) for a
 * full level of the tree stored in the stacks. The additional space for the
 * answer list does not count towards space complexity in terms of input size.
 * 
 * The `zigzagLevelOrder` method provides an elegant and efficient solution to
 * perform zigzag traversal on a binary tree, ensuring that nodes are visited in
 * a spiral order while maintaining a simple and effective data structure usage
 * strategy.
 */