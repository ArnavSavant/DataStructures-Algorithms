public class Leetcode_3097 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int bitsFrequency[] = new int[32];
        int i = 0;
        int j = 0;
        int OR = 0;
        int min = Integer.MAX_VALUE;
        while (j < n) {
            OR = OR | nums[j];
            addNumber(nums[j], bitsFrequency);
            if (OR >= k) {
                while (i <= j && OR >= k) {
                    min = Math.min(min, j - i + 1);
                    OR = OR - removeNumber(nums[i], bitsFrequency);
                    i++;
                }
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void addNumber(int num, int bitsFrequency[]) {
        int i = (0);
        while (num > 0) {
            if ((num & 1) == 1) {
                bitsFrequency[i]++;
            }
            num = num >> 1;
            i++;
        }
    }

    public int removeNumber(int num, int bitsFrequency[]) {
        int i = 0;
        int or = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                bitsFrequency[i]--;
                if (bitsFrequency[i] == 0) {
                    or = or + (int) Math.pow(2, i);
                }
            }
            num = num >> 1;
            i++;
        }
        return or;
    }
}
