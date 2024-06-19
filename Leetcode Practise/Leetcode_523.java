import java.util.HashMap;
import java.util.Map;
public class Leetcode_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (k != 0) {
                prefixSum %= k;
            }
            if (map.containsKey(prefixSum)) {
                if (i - map.get(prefixSum) > 1) {
                    return true;
                }
            } else {
                map.put(prefixSum, i);
            }
        }
        return false;
    }
}
