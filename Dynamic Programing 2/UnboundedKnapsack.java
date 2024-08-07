public class UnboundedKnapsack {
    public int knapsack(int n, int w, int val[], int wt[]) {
        return 0;
    }

    public int recursion(int ind, int weight, int val[], int wt[]) {
        if (ind == 0) {
            return (weight / wt[0]) * val[0];
        }
        int pick = 0;
        if (wt[ind] <= weight) {
            pick = val[ind] + recursion(ind, weight - wt[ind], val, wt);
        }
        int notPick = recursion(ind - 1, weight, val, wt);
        return Math.max(pick, notPick);
    }

    public int memorization(int ind, int weight, int val[], int wt[], int[][] dp) {
        if (ind == 0) {
            return (weight / wt[0]) * val[0];
        }
        if(dp[ind][weight] != -1) {
            return dp[ind][weight];
        }
        int pick = 0;
        if (wt[ind] <= weight) {
            pick = val[ind] + memorization(ind, weight - wt[ind], val, wt, dp);
        }
        int notPick = memorization(ind - 1, weight, val, wt, dp);
        return Math.max(pick, notPick);
    }

    public int tabulation(int n, int weight, int val[], int wt[]) {
        int dp[][] = new int[n][weight + 1];
        for (int i = 0; i <= weight; i++) {
            if (wt[0] <= i) {
                dp[0][i] = val[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (wt[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i] + dp[i][j - wt[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][weight];
    }
    public int spaceOptimized(int n, int weight, int val[], int wt[]) {
        int dp[] = new int[weight + 1];
        for (int i = 0; i <= weight; i++) {
            if (wt[0] <= i) {
                dp[i] = val[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (wt[i] <= j) {
                    dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
                }
            }
        }
        return dp[weight];
    }
}
