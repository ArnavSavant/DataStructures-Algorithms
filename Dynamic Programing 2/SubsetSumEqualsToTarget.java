public class SubsetSumEqualsToTarget {
    public boolean isSubsetSum(int N, int arr[], int sum) {
        // int dp[][] = new int[N + 1][sum + 1];
        // for (int i = 0; i <= N; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return recursion(N-1, sum, arr)
        // return memorization(N - 1, sum, arr, dp) == 1 ? true : false;
        return tabulation(arr, N, sum);
    }

    public boolean recursion(int i, int sum, int arr[]) {
        if (sum == 0) {
            return true;
        }
        if (i == 0) {
            return arr[0] == sum;
        }
        boolean notTake = recursion(i - 1, sum, arr);
        boolean take = false;
        if (sum >= arr[i]) {
            take = recursion(i - 1, sum - arr[i], arr);
        }
        return take || notTake;
    }

    public int memorization(int i, int sum, int[] arr, int dp[][]) {
        if (sum == 0) {
            return 1;
        }
        if (i == 0) {
            return arr[0] == sum ? 1 : 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int notTake = memorization(i - 1, sum, arr, dp);
        int take = 0;
        if (sum >= arr[i]) {
            take = memorization(i - 1, sum - arr[i], arr, dp);
        }
        return dp[i][sum] = take == 1 || notTake == 1 ? 1 : 0;
    }

    public boolean tabulation(int arr[], int n, int sum) {
        boolean dp[][] = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public boolean spaceOptimized(int arr[], int n, int sum) {
        boolean prev[] = new boolean[sum + 1];
        boolean dp[] = new boolean[sum + 1];
        if (arr[0] <= sum) {
            prev[arr[0]] = true;
            dp[arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            dp[0] = true;
            for (int j = 1; j <= sum; j++) {
                if (arr[i] <= j) {
                    dp[j] = prev[j] || prev[j - arr[i]];
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
