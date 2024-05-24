import java.util.Arrays;
public class Leetcode_3107 {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i < (n / 2) && nums[i] > k) {
                ans = ans + (nums[i] - k);
            } else if (i > (n / 2) && nums[i] < k) {
                ans = ans + (k - nums[i]);
            } else if (i == n / 2) {
                ans = ans + (Math.abs(nums[i] - k));
            }
        }
        return ans;
    }
}
