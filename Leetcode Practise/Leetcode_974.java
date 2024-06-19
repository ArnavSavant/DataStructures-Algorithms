import java.util.HashMap;
import java.util.Map;

public class Leetcode_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            int mod = (prefixSum % k + k) % k;

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
