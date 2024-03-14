import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraphUsingDFS {
    class Pair {
        int node;
        int parent;

        Pair(int n, int p) {
            this.node = n;
            this.parent = p;
        }
    }

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
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, node, visited, graph)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
