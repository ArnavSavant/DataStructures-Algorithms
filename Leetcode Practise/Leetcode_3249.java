import java.util.ArrayList;
import java.util.List;

public class Leetcode_3249 {
    public int countGoodNodes(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int ans[] = new int[1];
        dfs(graph, 0, visited, ans);
        return ans[0];
    }

    public int dfs(List<List<Integer>> graph, int node, boolean[] visited, int ans[]) {
        visited[node] = true;
        int count = 0;
        int prev = -1;
        boolean isGood = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                int s = dfs(graph, neighbour, visited, ans);
                if (prev == -1) {
                    prev = s;
                }
                count = count + s;
                if (prev != s) {
                    isGood = false;
                }
            }
        }
        if (isGood) {
            ans[0]++;
        }
        return count + 1;
    }
}
