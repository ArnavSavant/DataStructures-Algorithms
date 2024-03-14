import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_513 {
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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode curr = queue.poll();
                if (i == 1) {
                    temp = curr;
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return temp.val;
    }
}
/*
### Documentation for the `findBottomLeftValue` Method

#### Overview

The `findBottomLeftValue` method finds the value of the leftmost node at the bottom (last) level of a binary tree. This method uses level-order traversal to explore the tree, ensuring each level is fully visited before moving to the next. By keeping track of the first node at each level, the method guarantees that the leftmost node of the last level is identified.

#### Algorithm

1. **Initialization**: A queue is initialized and the root node is added to it. This queue will be used to perform the level-order traversal.

2. **Level-Order Traversal**: The method enters a loop that continues as long as there are nodes in the queue. For each iteration of the loop:
   - The size of the queue is noted (this represents the number of nodes at the current level).
   - The method iterates over these nodes, removing each from the queue.
   - The first node encountered at each level is stored in `temp`. This is achieved by checking if the current node is the first in its level (`i == 1`).
   - The children of the current node are added to the queue, ensuring that the traversal includes the next level of the tree.

3. **Identify Leftmost Value**: After the loop completes (the queue is empty, indicating the last level has been reached), `temp` holds the leftmost node of the bottom level. The value of `temp` (`temp.val`) is returned.

#### Why It Works

This method works because level-order traversal visits all nodes at a given level before moving to the next level. By tracking the first node at each level, the method ensures that when the traversal completes, the first node of the last level (which is the leftmost node at the bottom level) is identified. Since the traversal exhaustively covers every level, the method is guaranteed to reach the bottom level of the tree, and by prioritizing the first node in the level-order traversal, it accurately identifies the leftmost value.

#### Time and Space Complexity

- **Time Complexity**: O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once during the level-order traversal.

- **Space Complexity**: O(w), where w is the maximum width of the tree. This occurs when the queue contains all the nodes at the level with the maximum width, which represents the maximum amount of space needed at any point in the traversal.

#### Summary

The `findBottomLeftValue` method efficiently identifies the leftmost node at the bottom level of a binary tree through level-order traversal. By leveraging a queue to visit each level of the tree in order and tracking the first node at each level, the method ensures accurate identification of the target node. This approach provides a straightforward and effective solution to finding the bottom left value in a binary tree.
 */