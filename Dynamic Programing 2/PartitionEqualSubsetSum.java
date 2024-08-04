public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        // int dp[][] = new int[n][sum + 1];
        // for (int i = 0; i < n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // memorization(n - 1, sum, nums, dp);
        // return dp[n - 1][sum] == 1;
        return spaceOptimzed(n, sum, nums);
    }

    public boolean recursion(int ind, int sum, int nums[]) {
        if (sum == 0) {
            return true;
        }
        if (ind == 0) {
            return nums[0] == sum;
        }
        boolean pick = false;
        if (nums[ind] <= sum) {
            pick = recursion(ind - 1, sum - nums[ind], nums);
        }
        boolean noiPick = recursion(ind - 1, sum, nums);
        return pick || noiPick;
    }

    public int memorization(int ind, int sum, int nums[], int dp[][]) {
        if (sum == 0) {
            return 1;
        }
        if (ind == 0) {
            return nums[0] == sum ? 1 : 0;
        }
        if (dp[ind][sum] != -1) {
            return dp[ind][sum];
        }
        int pick = -1;
        if (nums[ind] <= sum) {
            pick = memorization(ind - 1, sum - nums[ind], nums, dp);
        }
        int noiPick = memorization(ind - 1, sum, nums, dp);
        return dp[ind][sum] = pick == 1 || noiPick == 1 ? 1 : 0;
    }

    public boolean tabulation(int n, int sum, int nums[]) {
        boolean dp[][] = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public boolean spaceOptimzed(int n, int sum, int nums[]) {
        boolean dp[] = new boolean[sum + 1];
        boolean prev[] = new boolean[sum + 1];
        if (nums[0] <= sum) {
            prev[nums[0]] = true;
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            dp[0] = true;
            for (int j = 1; j <= sum; j++) {
                if (nums[i] <= j) {
                    dp[j] = prev[j - nums[i]] || prev[j];
                } else {
                    dp[j] = prev[j];
                }
            }
            for (int k = 0; k <= sum; k++) {
                prev[k] = dp[k];
            }
        }
        return dp[sum];
    }
}
