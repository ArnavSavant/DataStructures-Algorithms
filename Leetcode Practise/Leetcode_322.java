public class Leetcode_322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        return spaceOptimized(coins, amount, n);
    }

    public int tabulation(int[] coins, int amount, int n) {
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = 10000000;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][amount] >= 10000000 ? -1 : dp[n - 1][amount];
    }

    public int spaceOptimized(int[] coins, int amount, int n) {
        int prev[] = new int[amount + 1];
        int dp[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
                dp[i] = i / coins[0];
            } else {
                prev[i] = 10000000;
                dp[i] = 10000000;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, prev[j]);
                } else {
                    dp[j] = prev[j];
                }
            }
            for (int k = 0; k <= amount; k++) {
                dp[k] = prev[k];
            }
        }
        return dp[amount] >= 10000000 ? -1 : dp[amount];
    }
}
