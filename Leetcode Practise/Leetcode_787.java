import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_787 {
    public class Pair {
        int val;
        int distance;
        
        Pair(int val, int distance) {
            this.val = val;
            this.distance = distance;
        }
    }

    public class Triplet {
        int stop;
        int val;
        int distance;

        Triplet(int stop, int val, int distance) {
            this.stop = stop;
            this.val = val;
            this.distance = distance;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(0, src, 0));
        distance[src] = 0;
        while (!queue.isEmpty()) {
            Triplet node = queue.remove();
            if (node.stop > k) {
                continue;
            }
            for (Pair neighbour : graph.get(node.val)) {
                if (node.distance + neighbour.distance < distance[neighbour.val] && node.stop <= k) {
                    distance[neighbour.val] = node.distance + neighbour.distance;
                    queue.add(new Triplet(node.stop + 1, neighbour.val, node.distance + neighbour.distance));
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
