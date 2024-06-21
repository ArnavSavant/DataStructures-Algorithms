public class HouseRobber {
    /*
     * recursive code
     * public int rob(int[] nums) {
     * return solve(nums, nums.length - 1);
     * }
     * public int solve(int nums[], int ind) {
     * if (ind == 0) {
     * return nums[ind];
     * }
     * if (ind < 0) {
     * return 0;
     * }
     * int pick = nums[ind] + solve(nums, ind - 2);
     * int notPick = 0 + solve(nums, ind - 1);
     * 
     * return Math.max(pick, notPick);
     * }
     */

    /*
     * Memorization Code
     * public int rob(int nums[]) {
     * int n = nums.length;
     * int dp[] = new int[n];
     * Arrays.fill(dp, -1);
     * return memorization(nums, n - 1, dp);
     * }
     * 
     * public int memorization(int nums[], int ind, int dp[]) {
     * if (ind == 0) {
     * return nums[ind];
     * }
     * if (ind < 0) {
     * return 0;
     * }
     * if (dp[ind] != -1) {
     * return dp[ind];
     * }
     * 
     * int pick = nums[ind] + memorization(nums, ind - 2, dp);
     * int notPick = 0 + memorization(nums, ind - 1, dp);
     * return dp[ind] = Math.max(pick, notPick);
     * }
     */

    /*
     * Tabluation Method
     * public int rob(int num[]) {
     * int n = num.length;
     * int dp[] = new int[n + 1];
     * dp[0] = num[0];
     * for (int i = 1; i < n; i++) {
     * int take = num[i];
     * if (i > 1) {
     * take = take + dp[i - 2];
     * }
     * int notTake = 0 + dp[i - 1];
     * dp[i] = Math.max(take, notTake);
     * }
     * return dp[n - 1];
     * }
     */

    // space-optimization
    public int rob(int num[]) {
        int n = num.length;
        if (n == 1) {
            return num[0];
        }
        int x = 0;
        int y = num[0];
        int curr = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int take = num[i];
            if (i > 1) {
                take = take + x;
            }
            int notTake = 0 + y;
            curr = Math.max(take, notTake);
            x = y;
            y = curr;
        }
        return curr;
    }
}
