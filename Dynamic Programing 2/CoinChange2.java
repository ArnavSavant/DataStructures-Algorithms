public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // for (int i = 0; i < n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        return tabulation(n, amount, coins);
    }

    public int recursion(int ind, int amount, int[] coins) {
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int pick = 0;
        if (coins[ind] <= amount) {
            pick = recursion(ind, amount - coins[ind], coins);
        }
        int notPick = 0 + recursion(ind - 1, amount, coins);
        return pick + notPick;
    }

    public int memorization(int ind, int amount, int coins[], int[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        int pick = 0;
        if (coins[ind] <= amount) {
            pick = memorization(ind, amount - coins[ind], coins, dp);
        }
        int notPick = 0 + memorization(ind - 1, amount, coins, dp);
        return dp[ind][amount] = pick + notPick;
    }

    public int tabulation(int n, int amount, int coins[]) {
        int dp[][] = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][amount];
    }
}
