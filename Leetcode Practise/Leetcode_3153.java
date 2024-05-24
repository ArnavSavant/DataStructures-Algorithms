import java.util.HashMap;
import java.util.Map;

public class Leetcode_3153 {
    public long sumDigitDifferences(int[] nums) {
        long ans = 0;
        int numOfDigits = (int) Math.floor(Math.log10(nums[0])) + 1;
        int n = nums.length;
        for (int i = 1; i <= numOfDigits; i++) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (mp.containsKey(nums[j] % 10)) {
                    mp.put(nums[j] % 10, mp.get(nums[j] % 10) + 1);
                } else {
                    mp.put(nums[j] % 10, 1);
                }
                nums[j] = nums[j] / 10;
            }
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                ans = ans + (entry.getValue() * (n - entry.getValue()));
            }
        }
        return ans;
    }
}
