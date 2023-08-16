public class LowerBound {
    public int findLowerBound(int nums[], int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return ans;
    }
}