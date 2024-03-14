import java.util.ArrayList;
import java.util.List;

public class TopologicalSortDFS {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean visited[] = new boolean[v];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, ans);
                ans.add(i);
            }
        }
        return ans;
    }

    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph, List<Integer> ans) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, graph, ans);
                ans.add(neighbour);
            }
        }
    }
}
