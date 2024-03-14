import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSinGraph {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {

        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);

            for (int x : adj.get(node)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        return bfs;
    }
}
