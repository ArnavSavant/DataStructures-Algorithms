import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_987 {

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

    public class Pair implements Comparable<Pair> {
        int row;
        int val;

        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }

        public int compareTo(Pair o) {
            if (this.row == o.row) {
                return Integer.compare(this.val, o.val);
            }
            return Integer.compare(this.row, o.row);
        }
    }

    public void fillMap(TreeNode root, Map<Integer, PriorityQueue<Pair>> mp, int row, int col) {
        if (root == null) {
            return;
        }
        PriorityQueue<Pair> temp;
        if (mp.containsKey(col)) {
            temp = mp.get(col);
        } else {
            temp = new PriorityQueue<>();
        }
        temp.offer(new Pair(row, root.val));
        mp.put(col, temp);
        fillMap(root.left, mp, row + 1, col - 1);
        fillMap(root.right, mp, row + 1, col + 1);

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, PriorityQueue<Pair>> mp = new HashMap<>();
        fillMap(root, mp, 0, 0);
        ArrayList<Integer> keys = new ArrayList<>(mp.keySet());
        Collections.sort(keys);
        for (int x : keys) {
            PriorityQueue<Pair> temp = mp.get(x);
            List<Integer> list = new ArrayList<>();
            while (temp.size() > 0) {
                list.add(temp.poll().val);
            }
            if (list.size() > 0) {
                ans.add(list);
            }
        }
        return ans;
    }
}
/*
### Documentation for the `verticalTraversal` Method

#### Logic of the Code

The `verticalTraversal` method performs a vertical order traversal of a binary tree and returns the values of the nodes as seen from the vertical perspective, sorted from left to right. If two nodes are in the same row and column, they are sorted by their values. The method employs a depth-first search (DFS) strategy encapsulated in the `fillMap` method to populate a map where each key represents a column index, and each value is a priority queue of `Pair` objects (representing nodes, with `row` indicating the node's row and `val` the node's value, sorted first by row then by value).

1. **Initialization**: A map `mp` is created to associate each vertical column with a priority queue that sorts nodes first by their row and then by their value.
2. **Populating the Map**: The `fillMap` method recursively traverses the tree, adding `Pair` objects representing each node to the appropriate priority queue in `mp`. The `col` parameter decreases for left subtrees and increases for right subtrees, ensuring that nodes are categorized by their correct vertical column. The `row` parameter increases as the traversal moves down each level, ensuring nodes are correctly ordered by depth.
3. **Extracting Sorted Values**: After the map is populated, the keys (representing column indices) are sorted to ensure left-to-right traversal. For each column, nodes are polled from the priority queue (ensuring they are retrieved in the correct order by row and value) and added to the final result list.

#### Intuition to Develop This Logic/Approach

This approach is developed from the need to:
- **Maintain vertical order**: Identifying each node's column position allows for grouping nodes vertically.
- **Preserve row order within columns**: Ensuring that nodes are considered top-down within each column.
- **Sort nodes with the same row and column**: A secondary sort by node values for nodes that overlap vertically.
  
The use of a map with column indices as keys and priority queues as values effectively addresses these needs, while the DFS strategy ensures that all nodes are visited and categorized appropriately.

#### Why This Code Works

This code works effectively for performing a vertical order traversal due to its methodical organization of nodes based on their vertical and horizontal positions, as well as their values. By using a priority queue sorted by row and value for each column index, it ensures that nodes are returned in the precise order required by the problem statement, regardless of the tree's structure.

#### Time and Space Complexities

- **Time Complexity**: The time complexity of this method is O(N log N) in the worst case, where N is the number of nodes in the tree. This accounts for inserting nodes into the priority queue (which has a log N insertion time) and the sorting of column keys.
  
- **Space Complexity**: The space complexity is O(N), as it stores all nodes in the map and priority queues, and the output list of lists.

The `verticalTraversal` method offers an efficient solution to the complex problem of sorting tree nodes by their vertical and horizontal positions, as well as by their values, ensuring that the vertical order traversal meets all specified criteria.
 */