import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_662 {
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int distanceFromMid;
        int isLeft;

        Pair(TreeNode node, int d, int isLeft) {
            this.node = node;
            this.distanceFromMid = d;
            this.isLeft = 1;
        }

        public int compareTo(Pair p) {
            return Integer.compare(this.distanceFromMid, p.distanceFromMid);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(new Pair(root, 0, 0));
        int level = 0;
        int currWidth = 0;
        int maxWidth = 0;
        while (!maxHeap.isEmpty()) {
            Pair curr1 = maxHeap.poll();
            Pair curr2 = maxHeap.poll();
            if (curr1 != null) {
                if (curr1.isLeft == 0) {
                    maxHeap.add(new Pair(curr1.node.left, (int) Math.pow(2, level), 1));
                    maxHeap.add(new Pair(curr1.node.right, (int) Math.pow(2, level), -1));
                } else if (curr1.isLeft == 1) {
                    maxHeap.add(new Pair(curr1.node.left, (int) Math.pow(2, level), 1));
                    maxHeap.add(new Pair(curr1.node.right, (int) Math.pow(2, level) - 1, -1));
                } else {
                    maxHeap.add(new Pair(curr1.node.left, (int) Math.pow(2, level) - 1, 1));
                    maxHeap.add(new Pair(curr1.node.right, (int) Math.pow(2, level), -1));
                }
            }
            if (curr2.isLeft == 0) {
                maxHeap.add(new Pair(curr2.node.left, (int) Math.pow(2, level), 1));
                maxHeap.add(new Pair(curr2.node.right, (int) Math.pow(2, level), -1));
            } else if (curr2.isLeft == 1) {
                maxHeap.add(new Pair(curr2.node.left, (int) Math.pow(2, level), 1));
                maxHeap.add(new Pair(curr2.node.right, (int) Math.pow(2, level) - 1, -1));
            } else {
                maxHeap.add(new Pair(curr2.node.left, (int) Math.pow(2, level) - 1, 1));
                maxHeap.add(new Pair(curr2.node.right, (int) Math.pow(2, level), -1));
            }
            maxWidth = Math.max(maxWidth, currWidth);
        }
        return 0;
    }
}
/*
The given implementation of `widthOfBinaryTree` intends to calculate the maximum width of a binary tree. The width of a binary tree is the maximum width among all levels, where the width of a level is defined as the number of nodes between the leftmost and rightmost non-null nodes in the level. However, the provided code contains several issues and does not correctly implement the logic to achieve its intended purpose. Let's address the problems and outline a correct approach.

### Problems in the Implementation

1. **Incorrect Usage of `PriorityQueue`**: The code uses a `PriorityQueue` with a custom `Pair` class that includes the node, its distance from the middle, and a flag indicating if it is left. However, the logic for adding new `Pair` objects to the queue does not correctly maintain the properties needed to calculate the width of each level.

2. **Misinterpretation of Level Width**: The width calculation logic, as intended, does not correctly compute the difference between the leftmost and rightmost nodes' indices at each level, which is crucial for determining the maximum width.

3. **Incorrect Level Traversal**: The code does not correctly implement level-order traversal, which is necessary for calculating the width of each level. There's an attempt to differentiate between left and right children using `isLeft` but it's not utilized correctly.

4. **Unutilized Variables**: Variables like `currWidth` and the condition checks within the while loop seem to be part of an unfinished logic for computing the width.

### Correct Approach

A more straightforward and effective approach to calculate the maximum width of a binary tree involves level-order traversal (BFS) with markers to identify the level changes. Each node can be associated with an index (starting from 0 or 1, depending on preference), and for each level, we record the indices of the first and last nodes encountered. The width of the level can then be computed as `lastIndex - firstIndex + 1`, and the maximum width is the maximum of all level widths.

#### Implementation Outline

1. Use a `Queue` to perform level-order traversal. Each element in the queue should be a pair containing a `TreeNode` and its index.

2. Initialize the queue with the root node and its index (0 or 1).

3. While the queue is not empty, process each level:
   - Record the index of the first and last nodes in the level.
   - For each node processed, enqueue its children with their respective indices (left child: `2 * index`, right child: `2 * index + 1`).

4. Update the maximum width after processing each level.

This approach accurately computes the width of each level using indices and naturally accommodates varying tree structures, including skewed trees.

### Time and Space Complexity

- **Time Complexity**: O(N), where N is the number of nodes in the tree. Each node is visited exactly once during the level-order traversal.

- **Space Complexity**: O(N), in the worst case, when the queue contains all nodes of a level. This situation occurs in a complete binary tree at its last level.
 */