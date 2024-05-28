import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int x : nums2) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int freq[] = new int[nums1[nums1.length - 1] + 1];
        for (int x : nums1) {
            if (x % k == 0) {
                freq[x / k] += mp.getOrDefault(x / k, 0);
            }
        }
        // freq[1] = mp.getOrDefault(1, 0);
        long count = 0;
        for (int x : nums1) {
            for (int i = 1; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    count += freq[i];
                }
                if (x / i != i) {
                    count += freq[x / i];
                }
            }
        }
        return count;
    }
}
