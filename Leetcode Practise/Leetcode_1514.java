import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1514 {
    public class Pair implements Comparable<Pair> {
        int node;
        double prob;

        Pair(int _node, double _prob) {
            this.node = _node;
            this.prob = _prob;
        }

        public int compareTo(Pair p) {
            if (this.prob == p.prob) {
                return Integer.compare(this.node, p.node);
            }
            return Double.compare(p.prob, this.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], Math.log(succProb[i])));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], Math.log(succProb[i])));

        }
        double dist[] = new double[n];
        Arrays.fill(dist, Double.NEGATIVE_INFINITY);
        PriorityQueue<Pair> maxeap = new PriorityQueue<>();
        dist[start_node] = 0;
        maxeap.add(new Pair(start_node, 0));
        while (!maxeap.isEmpty()) {
            Pair p = maxeap.poll();
            if (p.node == end_node) {
                Math.exp(dist[end_node]);
            }
            for (Pair neighbour : graph.get(p.node)) {
                if (p.prob + neighbour.prob > dist[neighbour.node]) {
                    dist[neighbour.node] = p.prob + neighbour.prob;
                    maxeap.add(new Pair(neighbour.node, p.prob + neighbour.prob));
                }
            }
        }
        return dist[end_node] == Double.NEGATIVE_INFINITY ? 0 : Math.exp(dist[end_node]);
    }
}
