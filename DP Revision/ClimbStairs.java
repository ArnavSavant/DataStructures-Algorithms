public class ClimbStairs {
    
    /*
     * recursive code
     * public int climbStairs(int n) {
     * if (n == 0) {
     * return 1;
     * }
     * if (n == 1) {
     * return 1;
     * }
     * return climbStairs(n - 1) + climbStairs(n - 2);
     * }
     */

    /*
     * memoization code
     * public int climbStairs(int n) {
     * int dp[] = new int[n + 1];
     * Arrays.fill(dp, -1);
     * dp[0] = 1;
     * dp[1] = 1;
     * return memorization(n, dp);
     * }
     * 
     * public int memorization(int n, int dp[]) {
     * if (dp[n] != -1) {
     * return dp[n];
     * }
     * return dp[n] = memorization(n - 1, dp) + memorization(n - 2, dp);
     * }
     */

    /*
     * tabluation code
     * public int climbStairs(int n) {
     * int dp[] = new int[n + 1];
     * dp[0] = 1;
     * dp[1] = 1;
     * for (int i = 2; i <= n; i++) {
     * dp[i] = dp[i - 1] + dp[i - 2];
     * }
     * return dp[n];
     * }
     */

    // space-optimization
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int x = 1;
        int y = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = x + y;
            x = y;
            y = curr;
        }
        return curr;
    }
}
