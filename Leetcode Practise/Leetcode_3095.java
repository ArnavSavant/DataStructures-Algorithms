public class Leetcode_3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int or = 0;
            for (int j = i; j < n; j++) {
                or = or | nums[j];
                if (or >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
