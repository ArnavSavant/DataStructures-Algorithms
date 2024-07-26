import java.util.HashMap;
import java.util.Map;

public class Leetcode_3223 {
    public int minimumLength(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char x : s.toCharArray()) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int length = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            length += entry.getValue() % 2 == 1 ? 1 : 2;
        }
        return length;
    }
}
