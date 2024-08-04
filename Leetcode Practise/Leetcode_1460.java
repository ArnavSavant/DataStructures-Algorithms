import java.util.HashMap;
import java.util.Map;

public class Leetcode_1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        for (int x : arr) {
            if (mp.containsKey(x)) {
                mp.put(x, mp.get(x) - 1);
                if (mp.get(x) == 0) {
                    mp.remove(x);
                }
            } else {
                return false;
            }
        }
        return mp.size() == 0;
    }
}
