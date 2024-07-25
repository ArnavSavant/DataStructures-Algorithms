import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    public int timer = 0;
    public List<Integer> findArticulationPoints(int n, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> ponts = new ArrayList<>();
        int time[] = new int[n];
        int low[] = new int[n];
        boolean visited[] = new boolean[n];
        boolean articulated[] = new boolean[n];
        dfs(0, -1, graph, visited, time, low, articulated);
        for (int i = 0; i < n; i++) {
            if (articulated[i]) {
                ponts.add(i);
            }
        }
        return ponts;
    }

    public void dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited, int[] time, int[] low,
            boolean[] articulated) {
        visited[node] = true;
        time[node] = timer;
        low[node] = timer;
        timer++;
        int child = 0;
        for (int neighbour : graph.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (!visited[neighbour]) {
                dfs(neighbour, node, graph, visited, time, low, articulated);
                low[node] = Math.min(low[node], low[neighbour]);
                if (low[neighbour] >= time[node] && parent != -1) {
                    articulated[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], time[neighbour]);
            }
        }
        if (child > 1 && parent == -1) {
            articulated[node] = true;
        }
    }
}
