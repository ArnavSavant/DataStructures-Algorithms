import java.util.HashMap;
import java.util.Map;

public class Leetcode_3005 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int maxFreq = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == maxFreq) {
                count++;
            }
        }
        return count * maxFreq;
    }
}
/*
public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int maxFreq = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == maxFreq) {
                count++;
            }
        }
        return count * maxFreq;
    }
 */