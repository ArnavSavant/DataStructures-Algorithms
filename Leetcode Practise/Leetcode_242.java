import java.util.HashMap;
import java.util.Map;

public class Leetcode_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
            } else {
                mp.put(s.charAt(i), 1);
            }
            if (mp.containsKey(t.charAt(i))) {
                mp.put(t.charAt(i), mp.get(t.charAt(i)) - 1);
            } else {
                mp.put(t.charAt(i), -1);
            }
            if (mp.get(s.charAt(i)) != null && mp.get(s.charAt(i)) == 0) {
                mp.remove(s.charAt(i));
            }
            if (mp.get(t.charAt(i)) != null && mp.get(t.charAt(i)) == 0) {
                mp.remove(t.charAt(i));
            }
        }
        if (mp.size() == 0) {
            return true;
        }
        return false;
    }
}
/*
Alright, let's unravel this enchanting spell of code that determines if two strings are anagrams of each other.

The primary idea behind checking if two strings are anagrams is that they should have the same set of characters with the same frequencies.

### Logic and Intuition:

1. **Length Check**:
   - If the lengths of `s` and `t` are different, it's impossible for them to be anagrams. Thus, we promptly return `false`.

2. **Using a HashMap**:
   - The heart of this method lies in using a `HashMap` to keep track of character counts. For every character in `s`, we increment its count, and for every character in `t`, we decrement its count. If `s` and `t` are anagrams, at the end of this process, all characters' counts in the map should be zero. 

3. **Populating the HashMap**:
   - We iterate over each character in the strings `s` and `t`.
     - If a character from `s` is found in the map, we increment its count.
     - If a character from `t` is found in the map, we decrement its count.
     - If any character's count becomes zero, it's removed from the map. This is an optimization step that ensures the map only contains characters with non-zero counts, which can be useful for larger strings or alphabets.

4. **Final Check**:
   - After iterating over all characters, if the two strings are anagrams, our map should be empty (since all characters would have equal frequencies in both strings, leading to a count of zero for each character). If the map is empty, return `true`, otherwise return `false`.

### Why does this work?

Imagine you have two bags of letter tiles, one for each string. You pull out a tile from the `s` bag and add a tile to a shared pile, and then you pull out a tile from the `t` bag and remove a tile from the shared pile. If the two strings are anagrams, by the time you've gone through all the tiles in both bags, the shared pile should be empty.

The `HashMap` in this code behaves like this shared pile. Adding and removing characters from the `s` and `t` strings should "cancel out" if they're anagrams. Thus, by the end of the process, the map should be empty.

### Concluding Thoughts:

This function provides an elegant solution to the problem of determining if two strings are anagrams. The use of a `HashMap` ensures that we can handle strings with larger character sets (like Unicode) with grace and efficiency. The time complexity of this method is \(O(n)\), where \(n\) is the length of the strings, making it a swift and efficient solution.
 */
