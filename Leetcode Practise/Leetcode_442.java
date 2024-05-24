import java.util.ArrayList;
import java.util.List;

public class Leetcode_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            } else {
                nums[x - 1] = nums[x - 1] * -1;
            }
        }
        return ans;
    }
}
