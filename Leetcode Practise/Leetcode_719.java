import java.util.Arrays;

public class Leetcode_719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = noOfPairs(nums, mid);
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int noOfPairs(int[] nums, int diff) {
        int left = 0;
        int right = 0;
        int count = 0;
        for (right = 0; right < nums.length; right++) {
            while (left < right && nums[right] - nums[left] > diff) {
                left++;
            }
            count = count + (right - left);
        }
        return count;
    }
}