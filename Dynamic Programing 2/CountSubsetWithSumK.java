public class CountSubsetWithSumK {
    public int countSubsetSum(int arr[], int n, int sum) {
        // int dp[][] = new int[n][sum + 1];
        // for (int i = 0; i < n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return memorization(n - 1, sum, arr, dp);
        // return tabulation(arr, sum, n);
        return spaceOptimized(n, sum, arr);
    }

    public int recursion(int ind, int sum, int arr[]) {
        if (sum == 0) {
            return 1;
        }
        if (ind == 0) {
            return sum == arr[0] ? 1 : 0;
        }
        int pick = 0;
        if (arr[ind] <= sum) {
            pick = recursion(ind - 1, sum - arr[ind], arr);
        }
        int notPick = recursion(ind - 1, sum, arr);
        return pick + notPick;
    }

    public int memorization(int ind, int sum, int arr[], int dp[][]) {
        if (sum == 0) {
            return 1;
        }
        if (ind == 0) {
            return sum == arr[0] ? 1 : 0;
        }
        if (dp[ind][sum] != -1) {
            return dp[ind][sum];
        }
        int pick = 0;
        if (arr[ind] <= sum) {
            pick = memorization(ind - 1, sum - arr[ind], arr, dp);
        }
        int notPick = memorization(ind - 1, sum, arr, dp);
        return dp[ind][sum] = pick + notPick;
    }

    public int tabulation(int arr[], int sum, int n) {
        int dp[][] = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] == sum) {
            dp[0][sum] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public int spaceOptimized(int n, int sum, int[] arr) {
        int prev[] = new int[sum + 1];
        int dp[] = new int[sum + 1];
        if (arr[0] <= sum) {
            prev[arr[0]] = 1;
            dp[arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0] = 1;
            for (int j = 1; j <= sum; j++) {
                if (arr[i] <= j) {
                    dp[j] = prev[j] + prev[j - arr[i]];
                } else {
                    dp[j] = prev[j];
                }
            }
            for (int k = 0; k <= sum; k++) {
                dp[k] = prev[k];
            }
        }
        return dp[sum];
    }
}
