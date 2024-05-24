import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_834 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int ans[] = new int[n];
        int count[] = new int[n];

        Arrays.fill(ans, 0);
        Arrays.fill(count, 1);
        dfsChildsContribution(0, -1, graph, ans, count);
        dfsParentsContribution(0, -1, graph, ans, count, n);
        return ans;
    }

    public void dfsParentsContribution(int node, int parent, List<List<Integer>> graph, int[] ans, int[] count, int n) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + (n - count[child]);
                dfsParentsContribution(child, node, graph, ans, count, n);
            }
        }
    }

    public void dfsChildsContribution(int node, int parent, List<List<Integer>> graph, int[] ans, int[] count) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfsChildsContribution(child, node, graph, ans, count);
                count[node] = count[node] + count[child];
                ans[node] = ans[node] + ans[child] + count[child];
            }
        }
    }
}
