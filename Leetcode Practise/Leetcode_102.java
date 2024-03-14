import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Leetcode_102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int noOfNodes = queue.size();
            List<Integer> level = new ArrayList<>();
            while (noOfNodes > 0) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    level.add(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                noOfNodes--;
            }
            ans.add(level);
        }
        return ans;
    }
}
/*
 * The provided code is an implementation of the Level Order Traversal algorithm
 * for binary trees. Level Order Traversal, also known as Breadth-First Search
 * (BFS) for trees, visits each node of the tree level-by-level from left to
 * right. This method is particularly useful for creating a snapshot of the tree
 * structure that reflects the hierarchy of nodes. Let's dive into the
 * components and the logic behind this implementation.
 * 
 * ### TreeNode Class
 * 
 * The `TreeNode` class is a basic construct for a binary tree node, which
 * includes:
 * - `val` (int): The value stored in the node.
 * - `left` (TreeNode): A reference to the left child.
 * - `right` (TreeNode): A reference to the right child.
 * 
 * It provides constructors for creating a node without children, a node with a
 * specific value, and a node with a value as well as left and right children,
 * allowing for versatile tree construction.
 * 
 * ### levelOrder Method
 * 
 * The `levelOrder` method performs the level order traversal on a binary tree
 * whose root node is provided as the input. It returns a list of lists, where
 * each inner list contains the values of the nodes at a specific depth in the
 * tree, starting from the root.
 * 
 * ### Algorithm Details
 * 
 * 1. **Initialization**:
 * - A list of lists `ans` is initialized to hold the result of the traversal.
 * - A queue `queue` is used to keep track of nodes and their children as they
 * are visited. The queue ensures that nodes are processed in the order they are
 * discovered, facilitating level-by-level traversal.
 * 
 * 2. **Starting Condition**:
 * - If the root is not null, it is added to the queue. This check prevents
 * attempting to process an empty tree.
 * 
 * 3. **Traversal**:
 * - The algorithm enters a loop that continues until the queue is empty,
 * indicating that all nodes have been processed.
 * - At the start of each iteration, `noOfNodes` is set to the current size of
 * the queue, which represents the number of nodes at the current level.
 * - An inner loop then processes each of these nodes: it dequeues a node
 * (`temp`), adds its value to the current level's list, and enqueues its
 * non-null children.
 * - After processing all nodes at the current level, the level's list is added
 * to the answer list, and the process repeats for the next level.
 * 
 * ### Logic and Intuition
 * 
 * The use of a queue is key to the BFS approach, as it naturally processes
 * nodes in the order they are discovered, ensuring that all nodes at one level
 * are processed before any nodes at the next level. The inner loop, which
 * iterates exactly `noOfNodes` times, ensures that each level is fully
 * processed before moving on to the next, allowing for the segregation of nodes
 * by their depth in the tree.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(n), where n is the number of nodes in the tree. Each
 * node is visited exactly once, making the time complexity linear relative to
 * the size of the tree.
 * 
 * - **Space Complexity**: O(w), where w is the maximum width of the tree. This
 * occurs at the level with the most nodes, which determines the maximum number
 * of elements that can be stored in the queue at any time. In the worst case,
 * for a perfectly balanced binary tree, the maximum width would be at the last
 * level with approximately n/2 nodes, making the space complexity O(n) in this
 * scenario. However, for the purpose of the overall complexity, it's more
 * accurate to describe it in terms of the maximum width.
 * 
 * This method efficiently captures the level-by-level structure of a binary
 * tree, using a queue to facilitate the breadth-first traversal process.
 */
