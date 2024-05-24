public class Leetcode_3101 {
    public long countAlternatingSubarrays(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        long count = 1;
        int i = 0;
        int j = 1;
        int lastDigit = nums[0];
        while (j < nums.length) {
            if (lastDigit == nums[j]) {
                i = j;
                count++;
            } else {
                count = count + (j - i + 1);
                lastDigit = nums[j];
            }
            j++;
        }
        return count;
    }
}
