import java.util.HashMap;
import java.util.Map;

public class Leetcode_3121 {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                mp.put(word.charAt(i), i);
            }
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z' && mp.containsKey((char) (c + 32))) {
                int ind = mp.get((char) (c + 32));
                if (ind < i) {
                    count++;
                }
                mp.remove((char) (c + 32));

            }
        }
        return count;
    }
}
