import java.util.ArrayList;
import java.util.List;

public class Leetcode_802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        boolean[] isSafe = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, isSafe, graph) == false) {
                    isSafe[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, boolean[] isSafe, int[][] graph) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbour : graph[node]) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, pathVisited, isSafe, graph)) {
                    return true;
                }
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }
        isSafe[node] = true;
        pathVisited[node] = false;
        return false;
    }
}
/*
The provided code defines a method, `eventualSafeNodes`, to identify "safe" nodes in a directed graph. A node is considered "safe" if it does not belong to any cycle and all paths starting from that node lead to a terminal node (a node with no outgoing edges).

### Algorithm

1. **Initialization**:
   - `ans`: A list to store indices of all safe nodes.
   - `n`: The number of nodes in the graph.
   - `isSafe`, `visited`, `pathVisited`: Boolean arrays initialized to `false`, used to track whether a node is safe, whether it has been visited during DFS, and whether it is currently on the DFS path, respectively.

2. **DFS Search**:
   - For each unvisited node in the graph, perform a DFS to detect cycles and identify safe nodes.
   - A node is marked as visited when it is first encountered.
   - If a node or any of its descendants is part of a cycle (detected when a node already on the DFS path is encountered again), mark it as unsafe.
   - Otherwise, upon completion of the DFS for a node without encountering a cycle, mark the node as safe and backtrack, marking it as not on the current path.

3. **Collect Safe Nodes**:
   - Iterate through the `isSafe` array, adding indices of safe nodes to the `ans` list.

### DFS Function

The `dfs` function recursively explores each node and its neighbors to check for cycles:
- It sets the current node as visited and part of the current DFS path.
- For each neighbor of the current node, if the neighbor is not visited, the function is called recursively. If a cycle is detected during any of these calls, the current path leads to an unsafe node.
- If a neighbor is already on the current DFS path (`pathVisited[neighbour]` is true), a cycle is detected, and the function returns true to indicate the presence of a cycle.
- If no cycles are detected from the current node, it is marked as safe, removed from the current DFS path, and the function returns false.

### Correction

There's a logical mistake in handling the `isSafe` marking in the main `eventualSafeNodes` method. The condition inside the loop should mark `isSafe[i] = true` when the `dfs` method returns `false` (indicating no cycle is detected starting from node `i`), not the other way around. 

### Corrected Implementation

To correct this logic:
```java
for (int i = 0; i < n; i++) {
    if (!visited[i]) {
        dfs(i, visited, pathVisited, isSafe, graph);
    }
}
```
And in the `dfs` method, the return condition should correctly reflect when a node is part of a cycle:
```java
if (!visited[neighbour] && dfs(neighbour, visited, pathVisited, isSafe, graph) || pathVisited[neighbour]) {
    return true;
}
```
This ensures nodes are correctly marked as safe based on the recursive exploration of the graph.

### Time and Space Complexity

- **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges in the graph. Each node and edge is explored at most once due to the memoization of the visited and safe states.
  
- **Space Complexity**: O(V), due to the storage of visited, pathVisited, and isSafe states for each node, as well as the recursion stack depth in the worst case.
 */