public class Leetcode_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return spaceOptimization(m, n, grid);
    }

    public int spaceOptimization(int row, int col, int[][] grid) {
        int dp[] = new int[col];
        int prev[] = new int[col];
        for (int i = 0; i < col; i++) {
            if (i == 0) {
                prev[i] = grid[0][0];
            } else {
                prev[i] = prev[i - 1] + grid[0][i];
            }
        }
        dp = prev;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[j] = grid[i][j] + prev[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], prev[j]);
                }
            }
            prev = dp;
        }
        return dp[col - 1];
    }
}
