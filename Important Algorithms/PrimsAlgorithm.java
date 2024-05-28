import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int wt) {
            this.node = node;
            this.weight = wt;
        }

        public int compareTo(Pair o) {
            if (this.weight == o.weight) {
                return Integer.compare(this.node, o.node);
            }
            return Integer.compare(this.weight, o.weight);
        }
    }

    class Triplet implements Comparable<Triplet> {
        int node;
        int weight;
        int parent;

        Triplet(int node, int wt, int p) {
            this.node = node;
            this.weight = wt;
            this.parent = p;
        }

        public int compareTo(Triplet o) {
            if (this.weight == o.weight) {
                return Integer.compare(this.node, o.node);
            }
            return Integer.compare(this.weight, o.weight);
        }
    }

    public int spannigTree(int[][] edges, int v) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.add(new Pair(0, 0));
        boolean visited[] = new boolean[v];
        int mstWeight = 0;
        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            if (visited[p.node]) {
                continue;
            }
            visited[p.node] = true;
            mstWeight = mstWeight + p.weight;
            for (Pair neighbour : graph.get(p.node)) {
                if (!visited[neighbour.node]) {
                    minHeap.add(neighbour);
                }
            }
        }
        return mstWeight;
    }

    public List<int[]> spanningTree(int[][] edges, int v) {

        List<List<Triplet>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Triplet(edge[1], edge[2], edge[0]));
            graph.get(edge[1]).add(new Triplet(edge[0], edge[2], edge[1]));
        }

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
        minHeap.add(new Triplet(0, 0, -1));
        boolean[] visited = new boolean[v];
        List<int[]> mstEdges = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Triplet p = minHeap.poll();
            if (visited[p.node]) {
                continue;
            }
            visited[p.node] = true;

            if (p.parent != -1) {
                mstEdges.add(new int[] { p.parent, p.node, p.weight });
            }

            for (Triplet neighbour : graph.get(p.node)) {
                if (!visited[neighbour.node]) {
                    minHeap.add(new Triplet(neighbour.node, neighbour.weight, p.node));
                }
            }
        }

        return mstEdges;
    }
}
