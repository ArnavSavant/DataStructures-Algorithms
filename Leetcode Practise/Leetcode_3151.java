public class Leetcode_3151 {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (((nums[i] ^ nums[i + 1]) & 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
