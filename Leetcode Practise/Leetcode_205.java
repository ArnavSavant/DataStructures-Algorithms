import java.util.HashMap;
import java.util.Map;

public class Leetcode_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<Character, Character>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            if(mp.containsKey(s.charAt(i))) {
                if(mp.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                }
            }
            else {
                if(mp.containsValue(t.charAt(i))) {
                    return false;
                }
                mp.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
/*
Ah, the enigmatic world of isomorphic strings! Let's dive into this captivating piece of code to understand its profound depths.

### Isomorphic Strings:

First and foremost, let's understand what "isomorphic" strings are. Two strings `s` and `t` are said to be isomorphic if each character in `s` can be replaced by a character in `t` to get the other string, ensuring a one-to-one mapping between the characters of the two strings. No two characters in `s` should map to the same character in `t` and vice-versa.

### The Code and Its Logic:

The primary goal of the code is to check if `s` and `t` are isomorphic.

A logical way to determine this is to maintain a mapping between characters from `s` to characters in `t`. 

1. **Initialization**:
   - A HashMap (`mp`) is initialized to keep track of the character-to-character mapping.
   - The variable `n` stores the length of the string `s` (assuming `s` and `t` are of equal length, as the problem statement doesn't specify otherwise).

2. **Iterating through the string**:
   - We traverse both strings `s` and `t` simultaneously using the loop variable `i`.
   
3. **Character Mapping**:
   - If the character from `s` (i.e., `s.charAt(i)`) already exists in our mapping:
     - We check if its mapped value in `t` matches the current character in `t` (i.e., `t.charAt(i)`). If not, the strings aren't isomorphic, so we return `false`.
   
   - If the character from `s` doesn't exist in our mapping:
     - We first ensure that the current character from `t` isn't already mapped to another character from `s` (this is done using `mp.containsValue(t.charAt(i))`). If it is, the strings aren't isomorphic, so we return `false`.
     - If all is good, we establish a new mapping between the current characters of `s` and `t`.

4. **Conclusion**:
   - If we complete the traversal without any discrepancies in the mapping, we deem the strings to be isomorphic and return `true`.

### Intuition:

Imagine you're a decoder trying to decode a secret language to English. Each word in the secret language corresponds to an English word. If, at any point, you find that a single character in the secret language could correspond to multiple English characters or vice versa, then the mapping isn't consistent, and the decoding becomes ambiguous.

Similarly, here we're ensuring a consistent, one-to-one mapping between the characters of the two strings.

In conclusion, this code elegantly ensures that such a one-to-one relationship exists between the characters of `s` and `t`, effectively determining their isomorphic nature.
 */
