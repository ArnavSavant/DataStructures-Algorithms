import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_199 {
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

    public static class Pair {
        TreeNode node;
        int row;

        Pair(TreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Pair> queue = new LinkedList<>();
        int lastRow = 0;
        queue.add(new Pair(root, 0));
        Pair prev = null;
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (curr.node.left != null) {
                queue.add(new Pair(curr.node.left, curr.row + 1));
            }
            if (curr.node.right != null) {
                queue.add(new Pair(curr.node.right, curr.row + 1));
            }
            if (curr.row != lastRow) {
                list.add(prev.node.val);
                lastRow = curr.row;
            }
            prev = curr;
        }
        list.add(prev.node.val);
        return list;
    }
}
/*
 * This code defines a method to find the right side view of a binary tree. The
 * right side view of a binary tree is the set of nodes visible when the tree is
 * viewed from the right side. The code uses a breadth-first search (BFS)
 * strategy, leveraging a queue to traverse the tree level by level, and
 * captures the last node seen at each level as the visible node from the right
 * side. Let's break down the components and logic of this code:
 * 
 * ### TreeNode Class
 * 
 * - `val`: The value of the node.
 * - `left`: Reference to the left child.
 * - `right`: Reference to the right child.
 * - Constructors are provided to create a node with different sets of initial
 * values and child nodes.
 * 
 * ### Pair Class
 * 
 * - This is a utility class used to associate each `TreeNode` with its row (or
 * depth) in the tree during the traversal. This association helps in
 * determining when we have moved to a new level of the tree.
 * 
 * ### rightSideView Method
 * 
 * - **Initialization**: The method starts by checking if the root is `null`. If
 * it is, it returns an empty list as there is no node to view from the right
 * side.
 * - **Queue for BFS**: A queue is used to hold `Pair` objects, each containing
 * a `TreeNode` and its corresponding row. The root node, along with its row
 * `0`, is initially added to the queue.
 * - **Traversal**: The method then enters a loop to process nodes level by
 * level until the queue is empty. For each node:
 * - It adds the node's left and right children (if they exist) to the queue,
 * with their corresponding row number incremented by `1`.
 * - It checks if the current node is at a new level (by comparing `curr.row`
 * with `lastRow`). If it is, this implies that the previous node (`prev`) was
 * the last node at its level and thus visible from the right side. Hence,
 * `prev.node.val` is added to the list.
 * - The `lastRow` variable is updated to the current row, and `prev` is updated
 * to the current node (`curr`).
 * 
 * - **Final Addition**: After exiting the loop, the method adds the value of
 * the last node processed (`prev.node.val`) to the list. This step is necessary
 * because the last node of the last level would not be added inside the loop.
 * 
 * ### Why This Code Works
 * 
 * - The code effectively captures the last node at each level by keeping track
 * of level changes (`curr.row != lastRow`). Whenever a level change is
 * detected, the last node of the previous level (stored in `prev`) is added to
 * the result list.
 * - By traversing the tree level by level and keeping track of the depth/row,
 * the algorithm ensures that only the rightmost node of each level is included
 * in the output.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(N), where N is the number of nodes in the binary
 * tree. Each node is visited exactly once during the BFS traversal.
 * - **Space Complexity**: O(W), where W is the maximum width of the tree. This
 * represents the worst-case scenario for the space taken up by the queue. In
 * the worst case, this could be O(N) when the tree is a complete binary tree.
 * However, for the output list, the space complexity is O(H), where H is the
 * height of the tree, since only one node per level is added to the list. The
 * overall space complexity considers both the queue and the output list, but
 * the queue dominates in the worst case.
 * 
 * This method efficiently computes the right side view using a level-order
 * traversal (BFS) while cleverly tracking level changes to identify the nodes
 * visible from the right side.
 */