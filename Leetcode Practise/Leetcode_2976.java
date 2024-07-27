import java.util.Arrays;

public class Leetcode_2976 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 97;
            int v = changed[i] - 97;
            int wt = cost[i];
            dist[u][v] = Math.min(dist[u][v], wt);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 97;
            int v = target.charAt(i) - 97;
            if (dist[u][v] != Integer.MAX_VALUE) {
                ans += dist[u][v];
            } else {
                return -1;
            }
        }
        return ans;
    }
}
