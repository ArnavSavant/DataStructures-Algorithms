import java.util.HashMap;
import java.util.Map;

public class Leetcode_409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        for (char x : s.toCharArray()) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        boolean flag = true;
        int length = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                if (flag) {
                    length += entry.getValue();
                    flag = false;
                } else {
                    length += entry.getValue() - 1;
                }
            }
        }
        return length;
    }
}
