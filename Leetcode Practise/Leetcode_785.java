import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(graph, color, i, n) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int[] color, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int colour;
            if (color[node] == 0) {
                colour = 1;
            } else {
                colour = 0;
            }
            for (int x : graph[node]) {
                if (color[x] == -1) {
                    color[x] = colour;
                    queue.add(x);
                } else if (color[x] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
The provided code is an implementation of a function to determine whether a given graph is bipartite. A graph is considered bipartite if its vertices can be divided into two disjoint sets such that every edge connects a vertex in one set to a vertex in the other set. The implementation uses Breadth-First Search (BFS) to assign colors to each vertex, ensuring no two adjacent vertices share the same color.

### Algorithm

1. **Initialization**:
   - Initialize an array `color` with the same length as the number of vertices in the graph (`n`). Each element is initially set to `-1`, indicating that no vertex has been colored yet.

2. **BFS for Each Component**:
   - Iterate over each vertex in the graph. If a vertex has not been colored (`color[i] == -1`), initiate a BFS from that vertex.
   - In the BFS, color the starting vertex with color `0` and add it to the queue.

3. **BFS Process**:
   - While the queue is not empty, dequeue a vertex and assign the opposite color to all its uncolored adjacent vertices. If an adjacent vertex is already colored with the same color as the current vertex, the graph cannot be bipartite, and the function returns `false`.
   - If BFS completes without conflicts, continue to the next uncolored vertex, if any.

4. **Check Bipartiteness**:
   - If all vertices can be colored without conflict, return `true`, indicating the graph is bipartite.

### Why It Works

The method leverages BFS to explore the graph level by level, coloring each vertex with one of two colors (represented by `0` and `1`). By coloring each vertex with the opposite color of its parent in the BFS tree, the algorithm ensures that no two adjacent vertices will have the same color if the graph is bipartite. Detecting a situation where a vertex would have to be both colors indicates the presence of an odd-length cycle, which violates the condition for a graph to be bipartite.

### Time and Space Complexity

- **Time Complexity**: O(n + e), where `n` is the number of vertices and `e` is the number of edges in the graph. Each vertex is visited once in the BFS process, and each edge is considered once for coloring adjacent vertices.

- **Space Complexity**: O(n), due to the queue used in the BFS process and the `color` array. The queue's size can grow up to O(n) in the worst case, where all vertices are in the queue.

### Summary

The `isBipartite` function effectively determines the bipartiteness of a graph using a BFS approach, systematically coloring the graph to ensure no two adjacent vertices share the same color. This method is efficient and straightforward, providing a clear solution to the problem of checking bipartiteness in graphs.
 */