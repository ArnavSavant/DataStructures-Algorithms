import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(graph, color, i, n) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int[] color, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int colour;
            if (color[node] == 0) {
                colour = 1;
            } else {
                colour = 0;
            }
            for (int x : graph[node]) {
                if (color[x] == -1) {
                    color[x] = colour;
                    queue.add(x);
                } else if (color[x] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
