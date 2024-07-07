public class Leetcode_3202 {
    public int maximumLength(int[] nums, int k) {
        int dp[][] = new int[k][k];
        int ans = 0;
        for (int x : nums) {
            int currRem = x % k;
            for (int prevRem = 0; prevRem < k; prevRem++) {
                dp[currRem][prevRem] = Math.max(dp[currRem][prevRem], dp[prevRem][currRem] + 1);
                ans = Math.max(ans, dp[currRem][prevRem]);
            }
        }
        return ans;
    }
}
