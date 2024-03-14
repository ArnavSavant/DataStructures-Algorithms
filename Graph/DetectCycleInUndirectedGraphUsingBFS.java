import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraphUsingBFS {
    class Pair {
        int node;
        int parent;

        Pair(int n, int p) {
            this.node = n;
            this.parent = p;
        }
    }

    boolean detectCycle(int V, List<List<Integer>> adj) {
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
                if (isCycle(i, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCycle(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));
        visited[node] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int x : graph.get(pair.node)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(new Pair(x, node));
                } else if (pair.parent != x) {
                    return true;
                }
            }
        }
        return false;
    }
}
