public class FrogJump {
    /*
     * Reccursive Code
     * public int minimumEnergy(int heights[], int n) {
     * if (n == 0) {
     * return 0;
     * }
     * int jumpOne = minimumEnergy(heights, n - 1) + Math.abs(heights[n - 1] -
     * heights[n]);
     * int jumpTwo = Integer.MAX_VALUE;
     * if (n > 1) {
     * jumpTwo = minimumEnergy(heights, n - 2) + Math.abs(heights[n - 2] -
     * heights[n]);
     * }
     * return Math.min(jumpOne, jumpTwo);
     * }
     */

    /*
     * Memorization Code
     * public int minimumEnergy(int heights[], int n) {
     * int dp[] = new int[n + 1];
     * Arrays.fill(dp, -1);
     * dp[0] = 0;
     * return memorization(heights, n, dp);
     * }
     * public int memorization(int heights[], int n, int[] dp) {
     * if (n == 0) {
     * return 0;
     * }
     * if (dp[n] != -1) {
     * return dp[n];
     * }
     * int jumpOne = memorization(heights, n - 1, dp) + Math.abs(heights[n - 1] -
     * heights[n]);
     * int jumpTwo = Integer.MAX_VALUE;
     * if (n > 1) {
     * jumpTwo = memorization(heights, n - 2, dp) + Math.abs(heights[n - 2]
     * - heights[n]);
     * }
     * return dp[n] = Math.min(jumpOne, jumpTwo);
     * }
     */

    /*
     * Tabluation Code
     * public int minimumEnergy(int heights[], int n) {
     * int dp[] = new int[n + 1];
     * dp[0] = 0;
     * for (int i = 1; i < n; i++) {
     * int jumpTwo = Integer.MAX_VALUE;
     * int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
     * if (i > 1)
     * jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
     * 
     * dp[i] = Math.min(jumpOne, jumpTwo);
     * }
     * return dp[n];
     * }
     */

    // space-optimized
    public int minimumEnergy(int heights[], int n) {
        int x = 0;
        int y = 0;
        int curr = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int jumpOne = x + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (i > 1) {
                jumpTwo = y + Math.abs(heights[i] - heights[i - 1]);
            }
            curr = Math.min(jumpOne, jumpTwo);
            x = y;
            y = curr;
        }
        return curr;
    }
}
