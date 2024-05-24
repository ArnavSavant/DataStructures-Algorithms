public class Leetcode_3115 {
    public int maximumPrimeDifference(int[] nums) {
        int first = -1, second = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                second = i;
                break;
            }
        }

        return Math.abs(first - second);
    }

    public boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        int sqrt = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrt; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
