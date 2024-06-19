import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 nums1[i] % (nums2[j]*k) == 0
 nums2[j]*k --> x
 */
public class Leetcode_3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int x : nums2) {
            mp.put(x * k, mp.getOrDefault(x * k, 0) + 1);
        }

        long count = 0;
        for (int x : nums1) {
            if (x % k == 0) {
                for (int i = 1; i <= Math.sqrt(x); i++) {
                    if (x % i == 0) {
                        count = count + mp.getOrDefault(i, 0);
                        if (x / i != i) {
                            count = count + mp.getOrDefault(x/i, 0);
                        }
                    }
                }
            }
        }
        return count;
    }
}
