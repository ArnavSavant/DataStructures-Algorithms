import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SingleSourceShortestPath {
    static class Pair {
        int value;
        int distance;

        Pair(int val, int dist) {
            this.value = val;
            this.distance = dist;
        }
    }

    public static int[] shortestPath(int n, int[][] edges, int src) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        boolean visited[] = new boolean[n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));
        visited[src] = true;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            ans[node.value] = node.distance;
            for (int neighbour : graph.get(node.value)) {
                if (!visited[neighbour]) {
                    queue.add(new Pair(neighbour, node.distance + 1));
                    visited[neighbour] = true;
                }
            }
        }
        return ans;
    }
}
