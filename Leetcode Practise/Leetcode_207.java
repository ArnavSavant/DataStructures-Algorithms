import java.util.ArrayList;
import java.util.List;

public class Leetcode_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int x[] : prerequisites) {
            graph.get(x[1]).add(x[0]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean pathVisited[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, graph) == true) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int start, boolean[] visited, boolean[] pathVisited, List<List<Integer>> graph) {
        visited[start] = true;
        pathVisited[start] = true;
        for (int neighbour : graph.get(start)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, pathVisited, graph)) {
                    return true;
                }
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }
        pathVisited[start] = false;
        return false;
    }
}
/*
### Documentation for the `canFinish` Method

#### Logic of the Code

The `canFinish` method is designed to determine if it is possible to complete all courses given a list of prerequisites. Each course is represented as an integer, and prerequisites are represented as pairs `[a, b]`, indicating that course `a` cannot be taken until course `b` has been completed. The method employs Depth-First Search (DFS) to detect cycles in the course prerequisite graph, as the presence of a cycle would mean that not all courses can be completed.

1. **Graph Construction**: A graph is constructed to represent the prerequisites as a list of adjacency lists. Each index in the graph corresponds to a course, and its list contains the courses that depend on it.

2. **Cycle Detection**: The method uses DFS to traverse the graph and detect cycles. Two boolean arrays, `visited` and `pathVisited`, are used to track visited nodes and nodes currently in the path of the DFS, respectively. A cycle is detected if a node is reached that is already in the current DFS path (`pathVisited` is true).

3. **DFS Traversal**: Starting from each unvisited node, DFS is performed. If during traversal, a node is encountered that has already been visited in the current path (`pathVisited` is true), a cycle is detected, and the method returns `true` for a cycle detected.

4. **Completing Courses**: If no cycle is detected in any DFS traversal, it means all courses can be completed, and the method returns `true`.

#### Intuition to Develop This Logic/Approach

The problem of determining whether all courses can be completed given a set of prerequisites can be mapped to detecting a cycle in a directed graph. Each course represents a node, and a prerequisite relationship represents a directed edge. Completing all courses is possible if and only if the graph has no cycles. DFS is a suitable approach for cycle detection in directed graphs, as it can track the path of traversal and identify if a node is revisited within the same path.

#### Why This Code Works

This code effectively solves the problem by transforming the prerequisites into a directed graph and applying DFS for cycle detection:
- The construction of the graph allows for an intuitive representation of the course dependencies.
- Using `visited` to track globally visited nodes and `pathVisited` to track nodes visited in the current DFS path helps distinguish between revisiting a node in the same traversal (indicating a cycle) and visiting a previously explored node from a different traversal path.
- The separation of visited nodes and the path visited logic is crucial for accurately detecting cycles specific to course prerequisites.

#### Time and Space Complexities

- **Time Complexity**: O(V + E), where V is the number of courses (vertices in the graph) and E is the number of prerequisites (edges in the graph). This complexity arises from needing to visit each vertex once and explore each edge once in the DFS.

- **Space Complexity**: O(V + E), due to the storage requirements of the graph (adjacency list) and the auxiliary space used for the `visited` and `pathVisited` arrays. The recursion stack used by DFS also contributes to the space complexity, with its depth potentially going up to O(V) in the case of a deep or linear graph.

The `canFinish` method offers an efficient solution to the course scheduling problem by using graph theory principles and DFS for cycle detection, ensuring that the course completion feasibility is accurately determined.
 */