import java.util.Arrays;

public class CherryPickup2 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // int row = 0;
        // int col1 = 0;
        // int col2 = n - 1;
        // return recursion(row, col1, col2, m, n, grid);
        // int[][][] dp = new int[m][n][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return memorization(row, col1, col2, m, n, grid, dp);

        return tabulation(grid, m, n);
    }

    public int recursion(int row, int col1, int col2, int m, int n, int[][] grid) {
        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) {
            return -1000000;
        }
        if (row == m - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j1 = -1; j1 <= 1; j1++) {
            for (int j2 = -1; j2 <= 1; j2++) {
                int curr = 0;
                if (col1 == col2) {
                    curr = grid[row][col1] + recursion(row + 1, col1 + j1, col2 + j2, m, n, grid);
                } else {
                    curr = grid[row][col1] + grid[row][col2] + recursion(row + 1, col1 + j1, col2 + j2, m, n, grid);
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public int memorization(int row, int col1, int col2, int m, int n, int[][] grid, int[][][] dp) {
        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) {
            return -1000000;
        }
        if (row == m - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }
        int max = Integer.MIN_VALUE;
        for (int j1 = -1; j1 <= 1; j1++) {
            for (int j2 = -1; j2 <= 1; j2++) {
                int curr = 0;
                if (col1 == col2) {
                    curr = grid[row][col1] + memorization(row + 1, col1 + j1, col2 + j2, m, n, grid, dp);
                } else {
                    curr = grid[row][col1] + grid[row][col2]
                            + memorization(row + 1, col1 + j1, col2 + j2, m, n, grid, dp);
                }
                max = Math.max(max, curr);
            }
        }
        return dp[row][col1][col2] = max;
    }

    public int tabulation(int[][] grid, int m, int n) {
        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                if (col1 == col2) {
                    dp[m - 1][col1][col2] = grid[m - 1][col1];
                } else {
                    dp[m - 1][col1][col2] = grid[m - 1][col1] + grid[m - 1][col2];
                }
            }
        }
        for (int row = m - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int max = Integer.MIN_VALUE;
                    for (int j1 = -1; j1 <= 1; j1++) {
                        for (int j2 = -1; j2 <= 1; j2++) {
                            int newCol1 = col1 + j1;
                            int newCol2 = col2 + j2;
                            if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                                int curr = 0;
                                if (col1 == col2) {
                                    curr = grid[row][col1] + dp[row + 1][newCol1][newCol2];
                                } else {
                                    curr = grid[row][col1] + grid[row][col2] + dp[row + 1][newCol1][newCol2];
                                }
                                max = Math.max(max, curr);
                            }
                        }
                    }
                    dp[row][col1][col2] = max;
                }
            }
        }
        return dp[0][0][n - 1];
    }
}
