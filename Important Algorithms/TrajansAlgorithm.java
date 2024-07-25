import java.util.ArrayList;
import java.util.List;

public class TrajansAlgorithm {
    public List<List<Integer>> getBridges(int n, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<List<Integer>> bridges = new ArrayList<>();
        int time[] = new int[n];
        int low[] = new int[n];
        boolean visited[] = new boolean[n];
        dfs(0, -1, graph, visited, time, low, 0, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited, int[] time, int[] low,
            int timer,
            List<List<Integer>> bridges) {
        visited[node] = true;
        time[node] = timer;
        low[node] = timer;
        timer++;
        for (int neighbour : graph.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (!visited[neighbour]) {
                dfs(neighbour, node, graph, visited, time, low, timer, bridges);
                low[node] = Math.min(low[node], low[neighbour]);
                if (low[neighbour] > time[node]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(neighbour);
                    bridges.add(bridge);
                }
            } else {
                low[node] = Math.min(low[node], time[neighbour]);
            }
        }

    }
}
