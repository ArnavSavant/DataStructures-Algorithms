public class Leetcode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return spaceOptimization(m, n, obstacleGrid);
    }

    public int spaceOptimization(int row, int col, int[][] obstacleGrid) {
        int[] dp = new int[col];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < col; j++) {
            dp[j] = (obstacleGrid[0][j] == 1) ? 0 : dp[j - 1];
        }

        for (int i = 1; i < row; i++) {
            dp[0] = (obstacleGrid[i][0] == 1) ? 0 : dp[0];

            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[col - 1];
    }
}
