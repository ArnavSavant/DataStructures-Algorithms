import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPath {
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

    public void printShortestPath(int[][] edge, int vertices, int edges, int source, int destination) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        List<List<Pair>> graph = new ArrayList<>();
        int[] distance = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            graph.get(edge[i][0]).add(new Pair(edge[i][1], edge[i][2]));
            graph.get(edge[i][1]).add(new Pair(edge[i][0], edge[i][2]));
        }
        minHeap.add(new Pair(source, 0));
        distance[source] = 0;
        parent[source] = -1;
        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            for (Pair neighbour : graph.get(p.node)) {
                if (p.dist + neighbour.dist < distance[neighbour.node]) {
                    distance[neighbour.node] = p.dist + neighbour.dist;
                    minHeap.add(new Pair(neighbour.node, p.dist + neighbour.dist));
                    parent[neighbour.node] = p.node;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int x = destination;
        while (x >= 0 && parent[x] != -1) {
            list.add(x);
            x = parent[x];
        }
        if (list.size() == 0) {
            list.add(-1);
        }
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        PrintShortestPath obj = new PrintShortestPath();
        int vertices = 5;
        int edges = 6;
        int[][] edge = {
                { 0, 1, 2 }, { 0, 2, 4 }, { 1, 2, 1 },
                { 1, 3, 7 }, { 2, 4, 3 }, { 3, 4, 1 }
        };
        int source = 0;
        int destination = 4;
        obj.printShortestPath(edge, vertices, edges, source, destination);
    }

}
