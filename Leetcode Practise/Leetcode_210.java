import java.util.ArrayList;
import java.util.List;

public class Leetcode_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int x[] : prerequisites) {
            graph.get(x[0]).add(x[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, graph, list)) {
                    return new int[] {};
                }
                list.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int k = 0;
        for (int x : list) {
            ans[k++] = x;
        }
        return ans;
    }

    private boolean dfs(int start, boolean[] visited, boolean[] pathVisited, List<List<Integer>> graph, List<Integer> list) {
        visited[start] = true;
        pathVisited[start] = true;
        for (int neighbour : graph.get(start)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, pathVisited, graph, list)) {
                    return true;
                } else {
                    list.add(neighbour);
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
 * The provided code aims to find an order in which all courses can be completed
 * given a list of prerequisites, represented by a 2D array where each pair `[a,
 * b]` indicates that course `a` requires course `b` as a prerequisite. If no
 * such order exists due to cycles in the prerequisite graph (meaning it's
 * impossible to complete all courses), the method returns an empty array. This
 * problem is a variation of the classic "Topological Sorting" in a directed
 * graph, with the goal of detecting cycles and, if none are found, returning a
 * valid courses completion order.
 * 
 * ### Corrected Logic of the Code
 * 
 * The original intention seems to be a topological sort to find a valid course
 * order, but the implementation has a critical issue in the way it adds courses
 * to the `list` and the direction of edges in the graph. Let's address these
 * issues:
 * 
 * 1. **Graph Construction**: Courses and their prerequisites are added to a
 * directed graph represented as a list of adjacency lists. However, the
 * direction of edges should be from prerequisites to courses (from `b` to `a`
 * in `[a, b]`), meaning if course `a` depends on course `b`, there should be an
 * edge from `b` to `a`. This is reversed in the provided code.
 * 
 * 2. **DFS Traversal**: A Depth-First Search (DFS) is used to traverse the
 * graph. Two boolean arrays, `visited` and `pathVisited`, are utilized to mark
 * nodes as visited globally and within the current DFS path, respectively, to
 * detect cycles.
 * 
 * 3. **Cycle Detection**: If a cycle is detected (a course is dependent on
 * itself directly or indirectly), the method returns an empty array, indicating
 * no valid order exists.
 * 
 * 4. **Topological Sort**: If no cycle is detected, the courses are added to
 * the `list` in a topologically sorted order. However, the placement of
 * `list.add(i);` outside the `if (!visited[i])` check and after the DFS call
 * results in an incorrect order. Courses should be added to the list *after*
 * all their dependencies are added (i.e., at the end of their DFS calls),
 * ensuring a correct topological order.
 * 
 * ### Corrected Code Strategy
 * 
 * - **Graph Direction**: Ensure that the graph is built with the correct edge
 * direction, from prerequisite to course.
 * - **Post-DFS Addition**: Modify the DFS function to add a course to the list
 * *after* recursively visiting all its prerequisites, ensuring the list
 * represents a valid topological order.
 * - **Result Array**: Reverse the list before converting it into an array, as
 * the correct topological order adds nodes post-recursion, meaning dependencies
 * are listed before dependents.
 * 
 * ### Time and Space Complexities
 * 
 * - **Time Complexity**: O(N + E), where N is the number of courses, and E is
 * the number of prerequisites. Each course and prerequisite is visited once.
 * - **Space Complexity**: O(N + E), for storing the graph, visited arrays, and
 * the recursion stack. The space for the output list/array is not counted
 * towards the complexity, as it is required for the output.
 * 
 * ### Correction in the Approach
 * 
 * To correct the approach and ensure a valid topological order:
 * - Fix the graph construction to correctly represent the direction from
 * prerequisites to courses.
 * - Adjust the DFS to add courses to the list at the end of their respective
 * DFS calls.
 * - Reverse the list before returning it as an array to reflect the correct
 * order from prerequisites to courses.
 * 
 * This corrected strategy will allow the `findOrder` method to accurately
 * perform a topological sort, providing a valid order for completing courses if
 * one exists, or returning an empty array if a cycle is detected, indicating no
 * such order is possible.
 */