import java.util.Arrays;

public class Leetcode_3250 {
    public int countOfPairs(int[] nums) {
        int[][][] dp = new int[nums.length][51][51];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int mod = 1000000007;
        // return memorization(0, 0, 50, nums, mod, dp);
        return tabulation(nums, mod);
    }

    public int recursion(int ind, int prev1, int prev2, int[] nums, int mod) {
        if (ind == nums.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= nums[ind]; i++) {
            int first = i;
            int second = nums[ind] - i;
            if (first >= prev1 && second <= prev2) {
                count += recursion(ind + 1, first, second, nums, mod) % mod;
            }
        }
        return count;
    }

    public int memorization(int ind, int prev1, int prev2, int[] nums, int mod, int[][][] dp) {
        if (ind == nums.length) {
            return 1;
        }
        if (dp[ind][prev1][prev2] != -1) {
            return dp[ind][prev1][prev2];
        }
        int count = 0;
        for (int i = 0; i <= nums[ind]; i++) {
            int first = i;
            int second = nums[ind] - i;
            if (first >= prev1 && second <= prev2) {
                count = (count + memorization(ind + 1, first, second, nums, mod, dp)) % mod;
            }
        }
        return dp[ind][prev1][prev2] = count;
    }

    public int tabulation(int nums[], int mod) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][51][51];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                dp[n][i][j] = 1;
            }
        }
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev1 = 0; prev1 <= 50; prev1++) {
                for (int prev2 = 0; prev2 <= 50; prev2++) {
                    int count = 0;
                    for (int k = Math.max(prev1, 0); k <= Math.min(50, nums[ind]); k++) {
                        int first = k;
                        int second = nums[ind] - k;
                        if (second <= prev2) {
                            count = (count + dp[ind + 1][first][second]) % mod;
                        }
                    }
                    dp[ind][prev1][prev2] = count;
                }
            }
        }
        return dp[0][0][50];
    }
}
