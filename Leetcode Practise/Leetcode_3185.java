import java.util.HashMap;
import java.util.Map;

public class Leetcode_3185 {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        for (int hour : hours) {
            int newHour = hour % 24;
            if (newHour == 0 && mp.containsKey(newHour)) {
                count = count + mp.get(newHour);
            } else if (mp.containsKey(24 - newHour)) {
                count = count + mp.get(24 - newHour);
            }
            mp.put(newHour, mp.getOrDefault(newHour, 0) + 1);
        }
        return count;
    }
}
