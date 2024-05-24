import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return null;

        }
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n = n - size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbour : graph.get(node)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
}
