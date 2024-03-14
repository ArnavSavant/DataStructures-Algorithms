import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    static class Pair {
        int value;
        int weight;

        Pair(int val, int wt) {
            this.value = val;
            this.weight = wt;
        }
    }

    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        boolean visited[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (distance[node] != Integer.MAX_VALUE) {
                for (Pair neighbour : graph.get(node)) {
                    if (distance[node] + neighbour.weight < distance[neighbour.value]) {
                        distance[neighbour.value] = distance[node] + neighbour.weight;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }

    public static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Pair>> graph) {
        visited[node] = true;
        for (Pair neighbour : graph.get(node)) {
            if (!visited[neighbour.value]) {
                dfs(neighbour.value, visited, stack, graph);
            }
        }
        stack.add(node);
    }
}
