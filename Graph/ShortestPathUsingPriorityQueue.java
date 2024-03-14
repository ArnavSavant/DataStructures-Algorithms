import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathUsingPriorityQueue {
    class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair p) {
            if (this.dist == p.dist) {
                return Integer.compare(this.node, p.node);
            }
            return Integer.compare(this.dist, p.dist);
        }
    }

    public List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        List<List<Pair>> graph = new ArrayList<>();
        int[] ans = new int[vertices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            graph.get(edge[i][0]).add(new Pair(edge[i][1], edge[i][2]));
            graph.get(edge[i][1]).add(new Pair(edge[i][0], edge[i][2]));
        }
        minHeap.add(new Pair(source, 0));
        ans[source] = 0;
        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            for (Pair neighbour : graph.get(p.node)) {
                if (p.dist + neighbour.dist < ans[neighbour.node]) {
                    ans[neighbour.node] = p.dist + neighbour.dist;
                    minHeap.add(new Pair(neighbour.node, p.dist + neighbour.dist));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int x : ans) {
            list.add(x);
        }
        return list;
    }
}
