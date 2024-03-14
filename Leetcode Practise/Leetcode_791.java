import java.util.HashMap;
import java.util.Map;

public class Leetcode_791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char x : s.toCharArray()) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        StringBuffer sb = new StringBuffer();
        for (char x : order.toCharArray()) {
            if (mp.containsKey(x)) {
                int count = mp.get(x);
                while (count != 0) {
                    sb.append(x);
                    count--;
                }
                mp.remove(x);
            }
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            char x = entry.getKey();
            int count = entry.getValue();
            while (count != 0) {
                sb.append(x);
                count--;
            }
        }
        return sb.toString();
    }
}
/*
The `customSortString` method sorts the characters of the string `s` according to the order defined in the string `order`. Characters in `s` that do not appear in `order` are appended to the end of the sorted string in any order. The method efficiently leverages a `HashMap` to count occurrences of each character in `s` and a `StringBuffer` to build the sorted string.

### Algorithm

1. **Character Frequency Map**: Iterate through the string `s`, populating a `HashMap` (`mp`) with each character as a key and its frequency as the value.

2. **Sort According to `order`**: Iterate through the string `order`. For each character `x` in `order`:
   - If `x` is found in `mp`, append `x` to the `StringBuffer` (`sb`) as many times as its frequency in `s`.
   - Remove `x` from `mp` after processing to avoid appending it again in the next step.

3. **Append Remaining Characters**: Iterate through the remaining entries in `mp`:
   - For each character, append it to `sb` as many times as its frequency. These characters are not in `order` but still appear in `s`.

4. **Return Sorted String**: Convert `sb` to a string and return it.

### Why It Works

This method accurately follows the custom sort order defined in `order` by prioritizing the placement of characters according to their sequence in `order`. Characters not present in `order` are appended at the end, ensuring all characters from `s` are included in the sorted string. Using a `HashMap` facilitates quick access to the frequency of each character, while the `StringBuffer` allows for efficient string construction.

### Time and Space Complexity

- **Time Complexity**: O(n + m), where `n` is the length of the string `s` and `m` is the length of the string `order`. The algorithm iterates over each string at most once, making the time complexity linear with respect to the total length of the input strings.

- **Space Complexity**: O(n), where `n` is the number of unique characters in `s`. The `HashMap` (`mp`) stores a frequency count for each unique character, and the `StringBuffer` (`sb`) scales with the length of `s`.

### Summary

The `customSortString` method provides a robust solution for sorting the characters of a string based on a custom order. It efficiently counts character frequencies, sorts characters per the custom order, and handles characters not specified in the order, ensuring a correctly sorted string is produced.
 */