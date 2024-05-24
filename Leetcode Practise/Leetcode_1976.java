import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1976 {
    class Pair implements Comparable<Pair> {
        int value;
        long distance;

        Pair(int val, long dst) {
            this.value = val;
            this.distance = dst;
        }

        public int compareTo(Pair p) {
            if (this.distance == p.distance) {
                return Integer.compare(this.value, p.value);
            }
            return Long.compare(this.distance, p.distance);
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new Pair(road[1], road[2]));
            graph.get(road[1]).add(new Pair(road[0], road[2]));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        long distance[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        minHeap.add(new Pair(0, 0));
        distance[0] = 0;
        ways[0] = 1;
        long mod = 1000000007;
        while (!minHeap.isEmpty()) {
            Pair node = minHeap.poll();
            for (Pair neighbour : graph.get(node.value)) {
                if (node.distance + neighbour.distance < distance[neighbour.value]) {
                    distance[neighbour.value] = node.distance + neighbour.distance;
                    minHeap.add(new Pair(neighbour.value, node.distance + neighbour.distance));
                    ways[neighbour.value] = ways[node.value];
                } else if (node.distance + neighbour.distance == distance[neighbour.value]) {
                    ways[neighbour.value] = (ways[neighbour.value] + ways[node.value]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);
    }
}
