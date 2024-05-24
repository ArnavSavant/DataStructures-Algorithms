import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_3112 {
    class Pair implements Comparable<Pair> {
        int value;
        int time;

        Pair(int v, int t) {
            this.value = v;
            this.time = t;
        }

        public int compareTo(Pair o) {
            if (this.time == o.time) {
                return Integer.compare(this.value, o.value);
            }
            return Integer.compare(this.time, o.time);
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        int[] time = new int[n];
        boolean[] finalized = new boolean[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        minHeap.add(new Pair(0, 0));
        while (minHeap.size() > 0) {
            Pair p = minHeap.poll();
            if (finalized[p.value]) {
                continue;
            }
            finalized[p.value] = true;
            for (Pair adj : graph.get(p.value)) {
                if ((!finalized[adj.value] && p.time + adj.time < time[adj.value]) && (p.time + adj.time < disappear[adj.value])) {
                    time[adj.value] = p.time + adj.time;
                    minHeap.add(new Pair(adj.value, p.time + adj.time));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (time[i] == Integer.MAX_VALUE) {
                time[i] = -1;
            }
        }
        return time;
    }
}
