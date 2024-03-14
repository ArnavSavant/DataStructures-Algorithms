import java.util.Queue;
import java.util.LinkedList;

public class Leetcode_297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("# ");
                continue;
            }
            sb.append(curr.val + " ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
/*
### Documentation for the `serialize` and `deserialize` Methods

The provided code implements two methods, `serialize` and `deserialize`, for converting a binary tree to a string representation and vice versa, enabling the storage or transmission of binary tree structures in a flat format.

#### Serialize Method

**Logic**: The `serialize` method converts a binary tree into a string representation using level-order traversal (BFS - Breadth-First Search). It employs a queue to traverse the tree iteratively. Each node's value is appended to a `StringBuffer`, separated by spaces. A placeholder "#" represents `null` children to preserve the tree structure in the string.

**Approach**:
1. If the root is `null`, return an empty string.
2. Initialize a `Queue` and add the root node.
3. While the queue is not empty, remove the front of the queue:
   - If the node is `null`, append "#" to the string.
   - Otherwise, append the node's value and add its left and right children to the queue (including `null` children).

**Why It Works**: This method captures the entire structure of the tree, including null children, ensuring that the original tree can be accurately reconstructed.

**Complexities**:
- Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
- Space Complexity: O(n), for the queue and the string buffer. The queue might hold at most the width of the tree at its last level, which can approach n/2 in a complete tree.

#### Deserialize Method

**Logic**: The `deserialize` method reconstructs a binary tree from its string representation. It splits the string into an array of values and uses a queue to assign children to each node sequentially.

**Approach**:
1. If the input string is empty, return `null`.
2. Split the string by spaces to get an array of values.
3. Initialize the root of the tree with the first value and add it to a queue.
4. Iterate through the array, assigning left and right children to nodes based on the queue's front element. Use "#" to skip assigning a `null` child.
5. For non-null children, create new nodes, assign them as children of the current node, and add them to the queue for their children's assignment.

**Why It Works**: This method sequentially assigns left and right children to each node, accurately following the order and structure represented in the string. The use of "#" for null children ensures that the tree structure is preserved.

**Complexities**:
- Time Complexity: O(n), where n is the number of nodes represented in the string. Each value in the array is processed exactly once.
- Space Complexity: O(n), primarily for the queue used in reconstructing the tree. The queue's size corresponds to the number of nodes at the tree's breadth, which can be up to n/2 for a complete tree at its last level.

### Summary

These methods provide an efficient way to serialize and deserialize binary trees, enabling their storage, transmission, and reconstruction while maintaining their structure and order. The use of level-order traversal for serialization and a queue-based reconstruction for deserialization ensures accuracy and efficiency.
 */