public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int ans = Integer.MAX_VALUE;
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }
        // for (int i = 0; i < n; i++) {
        // ans = Math.min(ans, memorization(0, i, m, n, dp, matrix));
        // }
        // return tabulation(matrix);
        return spaceOptimized(matrix);
    }

    public int recursion(int row, int col, int m, int n, int[][] matrix) {
        if (row == m - 1) {
            return matrix[row][col];
        }
        if (col < 0 || col == n) {
            return Integer.MAX_VALUE;
        }
        int left = recursion(row + 1, col - 1, m, n, matrix);
        int down = recursion(row + 1, col, m, n, matrix);
        int right = recursion(row + 1, col + 1, m, n, matrix);

        return matrix[row][col] + Math.min(down, Math.min(left, right));
    }

    public int memorization(int row, int col, int m, int n, int dp[][], int matrix[][]) {
        if (row == m - 1) {
            return matrix[row][col];
        }
        if (col < 0 || col == n) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int left = memorization(row + 1, col - 1, m, n, dp, matrix);
        int down = memorization(row + 1, col, m, n, dp, matrix);
        int right = memorization(row + 1, col + 1, m, n, dp, matrix);

        return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
    }

    public int tabulation(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }
        return minCost;
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
