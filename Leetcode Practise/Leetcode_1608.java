import java.util.Arrays;

public class Leetcode_1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= 100; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j]>=i) {
                    count++;
                }
            }
            if(count == i) {
                return i;
            }
        }
        return -1;
    }
}
