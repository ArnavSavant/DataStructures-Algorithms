public class Leetcode_416 {
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
        return spaceOptimzed(n, sum, nums);

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
