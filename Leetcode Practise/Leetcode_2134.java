public class Leetcode_2134 {
    public int minSwaps(int[] nums) {
        int count = 0;
        for (int x : nums) {
            if (x == 1) {
                count++;
            }
        }
        int n = nums.length;
        int i = 0;
        int j = -1;
        int curr = 0;
        int ans = Integer.MAX_VALUE;
        while (i < n) {
            if (j - i + 1 < count) {
                j++;
                if (nums[j % n] == 1) {
                    curr++;
                }
            }
            if (j - i + 1 == count) {
                ans = Math.min(ans, count - curr);
                if (nums[i % n] == 1) {
                    curr--;
                }
                i++;
            }
        }
        return ans;
    }
}
