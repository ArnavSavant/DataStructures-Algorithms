import java.util.Arrays;

public class PartitionArrayToMinimizeSum {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memorization(0, 0, 0, 0, n, 0, nums, dp);
    }

    public int recursion(int ind1, int ind2, int sum1, int sum2, int n, int ind, int[] nums) {
        if (ind1 == n && ind2 == n) {
            return Math.abs(sum1 - sum2);
        }
        if (ind1 == n) {
            return recursion(ind1, ind2 + 1, sum1, sum2 + nums[ind], n, ind + 1, nums);
        }
        if (ind2 == n) {
            return recursion(ind1 + 1, ind2, sum1 + nums[ind], sum2, n, ind + 1, nums);
        }
        int first = recursion(ind1 + 1, ind2, sum1 + nums[ind], sum2, n, ind + 1, nums);
        int second = recursion(ind1, ind2 + 1, sum1, sum2 + nums[ind], n, ind + 1, nums);
        return Math.min(first, second);
    }

    public int memorization(int ind1, int ind2, int sum1, int sum2, int n, int ind, int[] nums, int[][] dp) {
        if (ind1 == n && ind2 == n) {
            return Math.abs(sum1 - sum2);
        }
        if (ind1 == n) {
            return memorization(ind1, ind2 + 1, sum1, sum2 + nums[ind], n, ind + 1, nums, dp);
        }
        if (ind2 == n) {
            return memorization(ind1 + 1, ind2, sum1 + nums[ind], sum2, n, ind + 1, nums, dp);
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        int first = memorization(ind1 + 1, ind2, sum1 + nums[ind], sum2, n, ind + 1, nums, dp);
        int second = memorization(ind1, ind2 + 1, sum1, sum2 + nums[ind], n, ind + 1, nums, dp);
        return dp[ind1][ind2] = Math.min(first, second);
    }
}
