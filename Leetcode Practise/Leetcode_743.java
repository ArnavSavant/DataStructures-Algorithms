import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_743 {
    class Pair implements Comparable<Pair> {
        int val;
        int dst;

        Pair(int val, int dst) {
            this.val = val;
            this.dst = dst;
        }

        public int compareTo(Pair p) {
            if (p.dst == this.dst) {
                return Integer.compare(p.val, this.val);
            }
            return Integer.compare(p.dst, this.dst);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int time[] : times) {
            graph.get(time[0]).add(new Pair(time[1], time[2]));
        }
        int distance[] = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.add(new Pair(k, 0));
        distance[k] = 0;
        while (!minHeap.isEmpty()) {
            Pair node = minHeap.poll();
            for (Pair neighbour : graph.get(node.val)) {
                if (node.dst + neighbour.dst < distance[neighbour.val]) {
                    distance[neighbour.val] = node.dst + neighbour.dst;
                    minHeap.add(new Pair(neighbour.val, node.dst + neighbour.dst));
                }
            }
        }
        int minimumDelayTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            minimumDelayTime = Math.max(minimumDelayTime, distance[i]);
        }

        return minimumDelayTime == Integer.MAX_VALUE ? -1 : minimumDelayTime;
    }
}
