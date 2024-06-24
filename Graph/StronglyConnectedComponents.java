import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    public int kosaraju(int edges[][], int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean visited[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, stack);
            }
        }
        List<List<Integer>> graphAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphAdj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graphAdj.get(edge[1]).add(edge[0]);
        }
        Arrays.fill(visited, false);
        int countOfSCC = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, visited, graphAdj);
                countOfSCC++;
            }
        }
        return countOfSCC;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> graph, Stack<Integer> stack) {
        visited[node] = true;
        for (int neigbours : graph.get(node)) {
            if (!visited[neigbours]) {
                dfs(neigbours, visited, graph, stack);
            }
        }
        stack.push(node);
    }

    public void dfs2(int node, boolean[] visited, List<List<Integer>> graphAdj) {
        visited[node] = true;
        for (int neigbours : graphAdj.get(node)) {
            if (!visited[neigbours]) {
                dfs2(node, visited, graphAdj);
            }
        }
    }
}
