import java.util.Arrays;

public class Leetcode_547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        int[] connection = isConnected[node];
        for (int i = 0; i < connection.length; i++) {
            if (connection[i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
/*
### Documentation for the `findCircleNum` Method

#### Overview

The `findCircleNum` method is designed to find the number of provinces in a given undirected graph, represented by an adjacency matrix `isConnected`. A province is defined as a group of directly or indirectly connected cities, where each city is represented as a node in the graph. The adjacency matrix `isConnected` indicates whether each pair of cities is directly connected.

#### Algorithm

1. **Initialization**:
   - A boolean array `visited` is initialized to track whether a node (city) has been visited during the Depth-First Search (DFS). It is filled with `false` initially.
   - A counter `count` is used to keep track of the number of provinces found.

2. **Province Counting**:
   - The method iterates over each city (node) in the adjacency matrix.
   - If a city hasn't been visited, it triggers a DFS from that city, marking all reachable cities (within the same province) as visited.
   - After the DFS completes, the counter `count` is incremented to reflect the discovery of a new province.

3. **Depth-First Search (DFS)**:
   - The DFS function recursively visits unvisited cities that are directly connected to the current city (`node`), as indicated by `isConnected[node][i] == 1`.
   - It marks each visited city as `visited` to prevent revisiting and to denote all cities in the current DFS call as part of the same province.

#### Why It Works

This method effectively identifies provinces by leveraging DFS to explore all cities within a province as a single, connected component. By marking all cities reached during a single DFS call as visited, it ensures that each province is counted exactly once, regardless of the number of cities it contains. The use of the `visited` array prevents infinite loops and redundant visits, allowing the algorithm to efficiently enumerate distinct provinces.

#### Time and Space Complexity

- **Time Complexity**: O(n^2), where n is the number of cities. The algorithm must iterate through each element of the `isConnected` matrix once to ensure all connections are explored, leading to a quadratic time complexity relative to the number of cities.

- **Space Complexity**: O(n), due to the storage required for the `visited` array. The depth of the recursion stack can also contribute up to O(n) in space usage in the case of a densely connected graph.

#### Summary

The `findCircleNum` method provides an efficient approach to determining the number of provinces represented within an adjacency matrix. By utilizing DFS to group and count connected components within the graph, it offers a clear and effective solution to the problem of province identification, suitable for graphs represented by adjacency matrices.
 */