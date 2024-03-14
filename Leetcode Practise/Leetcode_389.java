import java.util.HashMap;
import java.util.Map;

public class Leetcode_389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (mp.containsKey(c)) {
                mp.put(c, mp.get(c) + 1);
            } else {
                mp.put(c, 1);
            }
        }
        for (char c : s.toCharArray()) {
            mp.put(c, mp.get(c) - 1);
            if (mp.get(c) == 0) {
                mp.remove(c);
            }
        }
        char ans = ' ';
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            ans = entry.getKey();
        }
        return ans;
    }
}
/*
### Documentation for the `findTheDifference` Method

#### Overview

The `findTheDifference` method is designed to find an extra character that is added to a string `t`, making it a shuffled version of string `s` with this one additional character. The method employs a hashmap to track the frequency of each character in strings `s` and `t`, allowing it to identify the character that is extra in `t`.

#### Algorithm

1. **Frequency Mapping for `t`**: Iterate over string `t`, and for each character, update its frequency in a hashmap. If the character is not already in the map, it is added with a frequency of 1. If it is already present, its frequency is incremented.

2. **Frequency Reduction for `s`**: Iterate over string `s`, and for each character, decrement its frequency in the hashmap. If the frequency of a character after decrementing is 0, it means the character's occurrences in `s` and `t` are balanced, and the character is removed from the hashmap.

3. **Identifying the Extra Character**: After processing both strings, the hashmap should contain only one entry: the extra character in `t` with its frequency. Iterate over the hashmap to extract this character.

#### Why It Works

This method works because it effectively counts the occurrences of each character in both strings and compares these counts. By incrementing counts for `t` and decrementing for `s`, it leverages the hashmap to keep track of discrepancies between the two strings. Since `t` is a shuffled version of `s` with one extra character, the hashmap will eventually contain only the extra character. This approach is based on the principle that adding and then subtracting the frequencies of identical characters will cancel out, leaving only the frequency of the extra character.

#### Time Complexity

- The time complexity of the method is **O(n + m)**, where `n` is the length of string `s` and `m` is the length of string `t`. This complexity arises because the method iterates over both strings once. The operations of adding, updating, and removing entries in the hashmap have an average time complexity of **O(1)**, so the total complexity is linear with respect to the lengths of the input strings.

#### Space Complexity

- The space complexity is **O(m)**, where `m` is the number of distinct characters in string `t`. In the worst case, all characters in `t` are unique, requiring a hashmap entry for each character. However, since the problem's constraint limits `t` to being a shuffled version of `s` with one extra character, the practical space requirement is closely tied to the size of the alphabet used in `s` and `t`, which is constant for most character sets (e.g., ASCII or Unicode).

#### Summary

The `findTheDifference` method provides an efficient and straightforward way to identify the extra character added to a shuffled string, using a hashmap to track and compare character frequencies in the original and modified strings.
 */