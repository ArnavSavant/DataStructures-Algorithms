import java.util.Arrays;

public class Leetcode_1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int city = -1;
        int minCities = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int noOfCities = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] <= distanceThreshold) {
                    noOfCities++;
                }
            }
            if (noOfCities <= minCities) {
                minCities = noOfCities;
                city = i;
            }
        }
        return city;
    }
}
