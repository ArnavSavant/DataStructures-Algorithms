import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode_2285 {
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        Collections.sort(graph, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return Integer.compare(b.size(), a.size());
            }
        });
        long max = 0;
        for (List<Integer> list : graph) {
            if (list.size() == 0) {
                break;
            }
            max = max + (n * list.size());
            n--;
        }
        return max;
    }
}
