import java.util.HashSet;
import java.util.Set;

public class Leetcode_3120 {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            }
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char x = (char) (c + 32);
                if (set.contains(x)) {
                    count++;
                    set.remove(x);
                }
            }
        }
        return count;
    }
}
