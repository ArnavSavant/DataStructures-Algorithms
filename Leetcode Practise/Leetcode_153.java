public class Leetcode_153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] >= nums[low]) {
                min = Math.min(min,nums[low]);
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                min = Math.min(min,nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
