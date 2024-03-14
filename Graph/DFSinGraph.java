import java.util.ArrayList;

public class DFSinGraph {
    public static void dfs_util(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> list, boolean visit[],
            int curr) {
        visit[curr] = true;
        list.add(curr);

        for (int val : graph.get(curr)) {
            if (!visit[val]) {
                dfs_util(graph, list, visit, val);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean visit[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (!visit[i]) {
                dfs_util(graph, temp, visit, i);
                ans.add(temp);
            }
        }
        return ans;
    }
}
