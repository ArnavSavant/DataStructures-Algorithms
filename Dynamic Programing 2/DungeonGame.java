public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        // int m = dungeon.length;
        // int n = dungeon[0].length;
        // return recursion(0, 0, m, n, dungeon);

        // int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return memorization(0, 0, m, n, dungeon, dp);

        return tabulation(dungeon);
    }

    public int recursion(int row, int col, int m, int n, int[][] dungeon) {
        if (row == m || col == n) {
            return Integer.MAX_VALUE;
        }
        if (row == m - 1 && col == n - 1) {
            return (dungeon[row][col] <= 0) ? -dungeon[row][col] + 1 : 1;
        }

        int right = recursion(row, col + 1, m, n, dungeon);
        int down = recursion(row + 1, col, m, n, dungeon);

        int minHealthRequired = Math.min(right, down) - dungeon[row][col];

        return minHealthRequired <= 0 ? 1 : minHealthRequired;
    }

    public int memorization(int row, int col, int m, int n, int[][] dungeon, int[][] dp) {
        if (row == m || col == n) {
            return Integer.MAX_VALUE;
        }
        if (row == m - 1 && col == n - 1) {
            return (dungeon[row][col] <= 0) ? -dungeon[row][col] + 1 : 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = memorization(row, col + 1, m, n, dungeon, dp);
        int down = memorization(row + 1, col, m, n, dungeon, dp);

        int minHealthRequired = Math.min(right, down) - dungeon[row][col];

        return dp[row][col] = minHealthRequired <= 0 ? 1 : minHealthRequired;
    }

    public int tabulation(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
