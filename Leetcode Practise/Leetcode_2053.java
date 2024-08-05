import java.util.HashMap;
import java.util.Map;

public class Leetcode_2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> mp = new HashMap<String, Integer>();
        for (String x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        for (String s : arr) {
            if (mp.containsKey(s) && mp.get(s) == 1) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }
        return "";
    }
}
