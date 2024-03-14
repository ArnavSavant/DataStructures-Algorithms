import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphUsingDFS {
    public boolean detectCycle(int V, List<List<Integer>> adj) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.size(); i++) {
            int a = adj.get(i).get(0);
            int b = adj.get(i).get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, graph)) {
                    return true;
                }
            }
        }
        return false;   
    }

    public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, pathVisited, graph)) {
                    return true;
                }
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
