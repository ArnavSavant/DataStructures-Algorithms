import java.util.List;

public class Leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return spaceOptimized(triangle);
    }
    public int spaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        int[] dp = new int[n];

        prev[0] = triangle.get(0).get(0);
        dp[0] = prev[0];
        for (int i = 1; i < n; i++) {
            dp[0] = triangle.get(i).get(0) + prev[0];
            for (int j = 1; j < i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(prev[j - 1], prev[j]);
            }
            dp[i] = triangle.get(i).get(i) + prev[i - 1];
            for (int k = 0; k <= i; k++) {
                prev[k] = dp[k];
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        return minCost;
    }
}
