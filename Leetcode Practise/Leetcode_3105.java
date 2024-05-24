public class Leetcode_3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1 || (n == 2 && (nums[0] != nums[1]))) {
            return n;
        }
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (j < n - 1) {
            if (nums[j + 1] > nums[j]) {
                j++;
            } else {
                max = Math.max(max, j - i + 1);
                j++;
                i = j;
            }
        }
        if (j == n - 1 && nums[j - 1] < nums[j]) {
            max = Math.max(max, j - i + 1);
        }
        i = 0;
        j = 0;
        while (j < n - 1) {
            if (nums[j + 1] < nums[j]) {
                j++;
            } else {
                max = Math.max(max, j - i + 1);
                j++;
                i = j;
            }
        }
        if (j == n - 1 && nums[j - 1] > nums[j]) {
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
