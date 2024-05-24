import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberOfOperations {
    static class Pair implements Comparable<Pair> {
        int steps;
        int value;

        Pair(int step, int val) {
            this.steps = step;
            this.value = val;
        }

        public int compareTo(Pair p) {
            if (p.steps == this.steps) {
                return Integer.compare(p.value, this.value);
            }
            return Integer.compare(p.steps, this.steps);
        }
    }

    public static int minimumOperations(int n, int start, int end, int[] a) {
        int mod = 1000;
        int distance[] = new int[mod];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.add(new Pair(0, start));
        distance[start] = 0;
        while (!minHeap.isEmpty()) {
            Pair node = minHeap.poll();
            for (int x : a) {
                if (node.steps + 1 < distance[(node.value * x) % mod]) {
                    distance[(node.value * x) % mod] = node.steps + 1;
                    minHeap.add(new Pair(node.steps + 1, (node.value * x) % mod));
                }
            }
        }
        return distance[end] == Integer.MAX_VALUE ? -1 : distance[end];
    }
}
