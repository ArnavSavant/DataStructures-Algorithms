public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        return tabulation(coins, amount, n);
    }

    public int recursion(int ind, int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return -1;
            }
        }
        int pick = Integer.MAX_VALUE;
        if (coins[ind] <= amount) {
            pick = 1 + recursion(ind - 1, amount - coins[ind], coins);
        }
        int notPick = 0 + recursion(ind - 1, amount, coins);
        return Math.min(pick, notPick);
    }

    public int memorization(int ind, int amount, int[] coins, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return 100000000;
            }
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        int pick = Integer.MAX_VALUE;
        if (coins[ind] <= amount) {
            pick = 1 + memorization(ind, amount - coins[ind], coins, dp);
        }
        int notPick = 0 + memorization(ind - 1, amount, coins, dp);
        return dp[ind][amount] = Math.min(pick, notPick);
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
