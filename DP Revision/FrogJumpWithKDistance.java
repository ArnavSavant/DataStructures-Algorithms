import java.util.Arrays;

public class FrogJumpWithKDistance {
    /*
     * Recursive Code
     * public int minimizeSteps(int heights[], int n, int k) {
     * if (n == 0) {
     * return 0;
     * }
     * int minimumSteps = Integer.MAX_VALUE;
     * for (int i = 1; i <= k; i++) {
     * if (n - i > 1) {
     * minimumSteps = Math.min(minimumSteps,
     * minimizeCost(heights, n - i, k) + Math.abs(heights[n - i] - heights[n]));
     * }
     * }
     * return minimumSteps;
     * }
     */

    /*
     * Memorization Code
     * public int minimizeSteps(int heights[], int n, int k) {
     * int dp[] = new int[n + 1];
     * Arrays.fill(dp, -1);
     * dp[0] = 0;
     * return memorization(heights, n, k, dp);
     * }
     * public int memorization(int heights[], int n, int k, int dp[]) {
     * if (n == 0) {
     * return 0;
     * }
     * if (dp[n] != -1) {
     * return dp[n];
     * }
     * int minimumSteps = Integer.MAX_VALUE;
     * for (int i = 1; i <= k; i++) {
     * if (n - i >= 0) {
     * int jump = memorization(heights, n - i, k, dp) + Math.abs(heights[n] -
     * heights[n - i]);
     * minimumSteps = Math.min(jump, minimumSteps);
     * }
     * }
     * return dp[n] = minimumSteps;
     * }
     */

    // Tabluation Method
    public int minimizeSteps(int heights[], int n, int k) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minimumSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minimumSteps = Math.min(minimumSteps, jump);
                }
            }
            dp[i] = minimumSteps;
        }
        return dp[n];
    }
}
