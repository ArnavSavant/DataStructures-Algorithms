public class Leetcode_518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return tabulation(n, amount, coins);
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

