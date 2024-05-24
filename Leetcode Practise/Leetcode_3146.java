import java.util.HashMap;
import java.util.Map;

public class Leetcode_3146 {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), i);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res + Math.abs(mp.get(t.charAt(i)) - i);
        }
        return res;
    }
}
