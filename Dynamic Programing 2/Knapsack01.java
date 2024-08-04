import java.util.Arrays;

public class Knapsack01 {
    public int solve(int[] wt, int[] value, int weight) {
        int n = wt.length;
        int dp[][] = new int[n][weight + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memorization(wt, value, weight, n, dp);
    }

    public int recursion(int[] wt, int[] value, int weight, int ind) {
        if (ind == 0) {
            if (wt[0] <= weight) {
                return value[0];
            } else {
                return 0;
            }
        }
        int notTake = recursion(wt, value, weight, ind - 1);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= weight) {
            take = value[ind] + recursion(wt, value, weight - wt[ind], ind - 1);
        }
        return Math.max(notTake, take);
    }

    public int memorization(int[] wt, int[] value, int weight, int ind, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= weight) {
                return value[0];
            } else {
                return 0;
            }
        }
        if (dp[ind][weight] != -1) {
            return dp[ind][weight];
        }
        int notTake = memorization(wt, value, weight, ind - 1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= weight) {
            take = value[ind] + memorization(wt, value, weight - wt[ind], ind - 1, dp);
        }
        return dp[ind][weight] = Math.max(notTake, take);
    }

    public int tabulation(int[] wt, int[] value, int weight) {
        int n = wt.length;
        int dp[][] = new int[n][weight + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        if (wt[0] <= weight) {
            dp[0][weight] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (wt[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i]] + value[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][weight];
    }
    
}
