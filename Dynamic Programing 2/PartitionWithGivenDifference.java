public class PartitionWithGivenDifference {
    public int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }
        if (totalSum - d < 0 || ((totalSum - d) % 2 == 1)) {
            return 0;
        }
        int s2 = (totalSum - d) / 2;

        // int dp[][] = new int[n][s2 + 1];
        // for (int row[] : dp) {
        // Arrays.fill(row, -1);
        // }
        // return recursion(n - 1, s2, arr);
        // return memorization(n - 1, s2, arr, dp);
        return tabulation(n, arr, s2);
    }

    public int recursion(int ind, int sum, int arr[]) {
        if (ind == 0) {
            if (sum == 0 && arr[0] == 0) {
                return 2;
            }
            if (sum == 0 || sum == arr[0]) {
                return 1;
            }
            return 0;
        }
        int pick = 0;
        if (arr[ind] <= sum) {
            pick = recursion(ind - 1, sum - arr[ind], arr);
        }
        int notPick = recursion(ind - 1, sum, arr);
        return pick + notPick;
    }

    public int memorization(int ind, int sum, int arr[], int dp[][]) {
        if (ind == 0) {
            if (sum == 0 && arr[0] == 0) {
                return 2;
            }
            if (sum == 0 || sum == arr[0]) {
                return 1;
            }
            return 0;
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

    public int tabulation(int n, int arr[], int sum) {
        int dp[][] = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] == 0) {
            dp[0][0] = 2;
        }
        if (arr[0] != 0 && arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[0]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public int spaceOptimized(int n, int sum, int[] arr) {
        int prev[] = new int[sum + 1];
        int dp[] = new int[sum + 1];
        if (arr[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
        }
        if (arr[0] != 0 && arr[0] <= sum) {
            prev[arr[0]] = 1;
            dp[arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
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
