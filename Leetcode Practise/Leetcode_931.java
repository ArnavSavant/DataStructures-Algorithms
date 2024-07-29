public class Leetcode_931 {
    public int minFallingPathSum(int[][] matrix) {
        return spaceOptimized(matrix);
    }

    public int spaceOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = matrix[i][j] + Math.min(prev[j], prev[j + 1]);
                } else if (j == n - 1) {
                    dp[j] = matrix[i][j] + Math.min(prev[j], prev[j - 1]);
                } else {
                    dp[j] = matrix[i][j] + Math.min(prev[j], Math.min(prev[j - 1], prev[j + 1]));
                }
            }
            for (int k = 0; k < n; k++) {
                prev[k] = dp[k];
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, prev[i]);
        }
        return minCost;
    }
}
