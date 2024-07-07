public class Leetcode_995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n];
        int flipCount = 0;
        int currentFlips = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                currentFlips -= flip[i - k];
            }

            if ((nums[i] + currentFlips) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                flip[i] = 1;
                currentFlips++;
                flipCount++;
            }
        }
        return flipCount;
    }
}
