import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class ShortestPathUsingSet {
    class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.dist != other.dist) {
                return Integer.compare(this.dist, other.dist);
            }
            return Integer.compare(this.node, other.node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return node == pair.node && dist == pair.dist;
        }

        @Override
        public int hashCode() {
            return 31 * node + dist;
        }
    }

    public List<Integer> dijkstra(int[][] edges, int vertices, int source) {
        TreeSet<Pair> set = new TreeSet<>();
        List<List<Pair>> graph = new ArrayList<>();
        int[] ans = new int[vertices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[source] = 0;

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));

        }

        set.add(new Pair(source, 0));
        while (!set.isEmpty()) {
            Pair currentPair = set.pollFirst();
            int currentNode = currentPair.node;
            for (Pair neighbour : graph.get(currentNode)) {
                if (ans[currentNode] + neighbour.dist < ans[neighbour.node]) {
                    Pair newPair = new Pair(neighbour.node, ans[neighbour.node]);
                    if (set.contains(newPair)) {
                        set.remove(newPair);
                    }
                    ans[neighbour.node] = ans[currentNode] + neighbour.dist;
                    set.add(new Pair(neighbour.node, ans[neighbour.node]));
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
