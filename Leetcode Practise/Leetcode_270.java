public class Leetcode_270 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int count = 0;
        long currSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currSum += nums[i];
            if (currSum >= (sum - currSum)) {
                count++;
            }
        }
        return count;
    }
}
