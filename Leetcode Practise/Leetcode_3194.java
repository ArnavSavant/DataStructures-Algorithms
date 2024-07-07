import java.util.Arrays;

public class Leetcode_3194 {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        double min = Double.MAX_VALUE;
        while (i <= j) {
            min = Math.min((nums[i] + nums[j]) / (2 * 1.0), min);
            i++;
            j--;
        }
        return min;
    }
}
