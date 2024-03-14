import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1609 {
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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level % 2 == 0) {
                int min = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.val > min && temp.val % 2 == 1) {
                        min = temp.val;
                    } else {
                        return false;
                    }
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            } else {
                int max = 1000001;
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.val < max && temp.val % 2 == 0) {
                        max = temp.val;
                    } else {
                        return false;
                    }
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
            level++;
        }
        return true;
    }
}
/*
### Documentation for the `isEvenOddTree` Method

#### Logic of the Code

The `isEvenOddTree` method checks whether a binary tree is an even-odd tree. An even-odd tree meets the following conditions:
- At even levels (0, 2, 4, ...), nodes' values are strictly increasing and odd.
- At odd levels (1, 3, 5, ...), nodes' values are strictly decreasing and even.

The method uses a breadth-first search (BFS) strategy, leveraging a queue to traverse the tree level by level. For each level, it performs the following checks based on the level's parity (even or odd):
- **Even Level Check**: The values must be strictly increasing and odd. It initializes a minimum value `min` to `0` and checks each node in the level to ensure its value is greater than `min` and odd. If a node violates these conditions, the tree does not satisfy the even-odd tree criteria, and the method returns `false`.
- **Odd Level Check**: The values must be strictly decreasing and even. It initializes a maximum value `max` to a large number (1000001) and checks each node in the level to ensure its value is less than `max` and even. Similar to the even level check, if a node violates these conditions, the method returns `false`.

After processing a node, the method enqueues its children (left first, then right) to the queue for subsequent level checks.

#### Intuition to Develop This Logic/Approach

The approach leverages the level-order traversal technique to examine each tree level's nodes against the even-odd tree criteria. This method is intuitive because it directly applies the even-odd tree definition, ensuring that all nodes at each level conform to the specified rules regarding their values' parity and order. Using a queue for BFS is a natural choice for level-wise traversal, allowing the method to efficiently process nodes level by level.

#### Why This Code Works

This code effectively identifies even-odd trees by directly applying the criteria that define such trees. By incrementally verifying each level's adherence to the rules—odd and strictly increasing values at even levels, and even and strictly decreasing values at odd levels—it ensures that any deviation from these criteria results in an immediate `false` return. This direct mapping between the problem statement and the solution strategy ensures the method's correctness.

#### Time and Space Complexities

- **Time Complexity**: The method has a time complexity of O(n), where n is the number of nodes in the tree. This is because each node is visited exactly once during the level-order traversal.
  
- **Space Complexity**: The space complexity is O(w), where w is the maximum width of the tree. This accounts for the space needed to store the queue's contents, which peaks at the tree's widest level. In the worst-case scenario (a perfectly balanced tree), this would be proportional to n/2, leading to O(n) space complexity.

The `isEvenOddTree` method efficiently verifies the even-odd tree property using a level-order traversal approach, ensuring a straightforward and effective solution to the problem.
 */