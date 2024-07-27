public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // return recursion(m, n, grid);

        // int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return memorization(m - 1, n - 1, grid, dp);

        // return tabulation(m, n, grid);

        return spaceOptimization(m, n, grid);

    }

    public int recursion(int row, int col, int[][] grid) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        int left = recursion(row, col - 1, grid);
        int up = recursion(row - 1, col, grid);
        return grid[row][col] + Math.min(left, up);
    }

    public int memorization(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int left = memorization(row, col - 1, grid, dp);
        int up = memorization(row - 1, col, grid, dp);
        return dp[row][col] = grid[row][col] + Math.min(left, up);
    }

    public int tabulation(int row, int col, int[][] grid) {
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row - 1][col - 1];
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
