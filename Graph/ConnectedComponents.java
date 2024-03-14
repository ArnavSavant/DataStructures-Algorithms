import java.util.Arrays;

public class ConnectedComponents {
    public static int findNumOfProvinces(int[][] roads, int n) {
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(roads, n, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] roads, int n, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (roads[node][i] == 1 && !visited[i]) {
                dfs(roads, n, visited, i);
            }
        }
    }
}
