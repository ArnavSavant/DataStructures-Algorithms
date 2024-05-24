import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    static class Pair {
        int value;
        int distance;

        Pair(int val, int dst) {
            this.value = val;
            this.distance = dst;
        }
    }

    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src - 1] = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (List<Integer> edge : edges) {
                if (distance[edge.get(0) - 1] + edge.get(2) < distance[edge.get(1) - 1]) {
                    distance[edge.get(1) - 1] = distance[edge.get(0) - 1] + edge.get(2);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }
}
