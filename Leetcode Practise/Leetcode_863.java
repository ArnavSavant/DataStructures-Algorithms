import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leetcode_863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void fiillParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
                parentMap.put(temp.left, temp);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                parentMap.put(temp.right, temp);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, Boolean> isVisited = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        fiillParents(root, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        isVisited.put(target, true);
        int currDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currDistance == k) {
                break;
            }
            currDistance++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !isVisited.containsKey(curr.left)) {
                    queue.offer(curr.left);
                    isVisited.put(curr.left, true);
                }
                if (curr.right != null && !isVisited.containsKey(curr.right)) {
                    queue.offer(curr.right);
                    isVisited.put(curr.right, true);
                }
                if (parentMap.containsKey(curr) && !isVisited.containsKey(parentMap.get(curr))) {
                    queue.offer(parentMap.get(curr));
                    isVisited.put(parentMap.get(curr), true);
                }
            }
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }
}
/*
The provided code defines a method `distanceK` to find all the values of nodes that are at distance `k` from a target node in a binary tree. This approach utilizes breadth-first search (BFS) and maintains a parent map to explore the tree not only by children but also by parent references, allowing the algorithm to move upwards from any node.

### Steps in the Algorithm

1. **Fill Parent Map (`fiillParents`)**:
   - A BFS traversal starting from the root to fill a map (`parentMap`) that keeps track of the parent for each node. This allows moving upwards from any node in the tree.

2. **BFS to Find Nodes at Distance `k`**:
   - Another BFS is initiated from the target node. This search includes moving to left and right children as well as to the parent node, effectively covering all possible directions.
   - A map (`isVisited`) is used to keep track of visited nodes to prevent revisiting and hence, looping indefinitely.
   - The search stops expanding further once the current distance from the target node equals `k`. The remaining nodes in the queue at this level are exactly at distance `k` from the target.

3. **Collect and Return Result**:
   - The remaining nodes in the queue, which are at distance `k`, are collected into a list (`ans`) and returned.

### Corrections and Enhancements

The code is well-structured and implements the required functionality correctly. The method name `fiillParents` appears to have a typo and could be renamed to `fillParents` for clarity. 

### Time and Space Complexity

- **Time Complexity**: O(N), where N is the number of nodes in the binary tree. Each node is visited at most twice (once to fill the parent map and once during the BFS from the target node), leading to a linear time complexity.
  
- **Space Complexity**: O(N) due to the space needed for the parent map, the visited map, and the queue used in BFS. In the worst case, these data structures might need to store information about every node in the tree.

### Summary

The `distanceK` method effectively utilizes BFS and a parent map to find all nodes at a given distance `k` from a target node in a binary tree. This solution efficiently traverses the tree in all directions from the target node, ensuring all potential nodes at the specified distance are found and returned.
 */