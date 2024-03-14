import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {
    public List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int inDegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (int neighbour : graph.get(i)) {
                inDegree[neighbour]++;
            }
        }
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            for (int neighbour : graph.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KahnsAlgorithm obj = new KahnsAlgorithm();
        int[][] edges = { { 5, 0 }, { 4, 0 }, { 5, 2 }, { 4, 1 }, { 2, 3 }, { 3, 1 } };
        System.out.println(obj.topologicalSort(edges, 6, 6));
    }
}
