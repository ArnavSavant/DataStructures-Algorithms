import java.util.HashMap;
import java.util.Map;

public class Leetcode_424 {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int ans = Integer.MIN_VALUE;
        while (j < s.length()) {
            if (mp.containsKey(s.charAt(j))) {
                mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            } else {
                mp.put(s.charAt(j), 1);
            }
            maxFreq = Math.max(maxFreq, mp.get(s.charAt(j)));
            while ((j - i + 1) - maxFreq > k) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) {
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            ans = Math.max(j - i + 1, ans);
            j++;
        }
        return ans;
    }
}
/*
The provided Java function `characterReplacement` is designed to find the length of the longest substring you can obtain in the string `s` by replacing at most `k` characters with any letter such that all characters in the substring are the same.

### Logic and Intuition:

1. **HashMap Tracking (`mp`)**:
   - A hashmap `mp` is used to keep track of the frequency of each character in the current window (substring).

2. **Sliding Window**:
   - Two pointers, `i` and `j`, are used to define the current window's boundaries within the string `s`. The window is expanded by moving `j` to the right.

3. **Updating Character Frequencies**:
   - As each character is encountered, its count is updated in `mp`. The `maxFreq` variable keeps track of the frequency of the most frequent character in the current window.

4. **Window Validation**:
   - The condition `(j - i + 1) - maxFreq > k` checks if the current window is valid. A valid window is one where the number of characters that need to be replaced (which is the window's length minus the frequency of the most common character) is less than or equal to `k`.

5. **Shrinking the Window**:
   - If the current window is not valid, the window is shrunk from the left by moving `i` to the right. Before incrementing `i`, the frequency of the character at `i` is decremented. If the frequency drops to zero, that character is removed from the hashmap.

6. **Calculating the Answer (`ans`)**:
   - After possibly shrinking the window to ensure it's valid, the length of the current window (`j - i + 1`) is compared with the maximum length found so far (`ans`), and `ans` is updated if necessary.

### Why It Works:

The algorithm leverages a sliding window to keep track of a dynamic subset of the string `s`. The key insight is that in the longest valid substring, the most frequent character plus the allowed replacements (`k`) will equal the length of the substring. By keeping track of the maximum frequency of any character (`maxFreq`), the algorithm ensures that at each step, the window represents the longest valid substring that ends at `j`. If the window becomes invalid, it's shrunk until it becomes valid again.

### Complexity:

- **Time Complexity**: \( O(26 \cdot n) \) or simplified to \( O(n) \), where \( n \) is the length of the string `s`. In the worst case, each character might be visited twice (once when the right pointer `j` moves right, and once when the left pointer `i` moves right), and at each step, the frequency update operations are \( O(1) \) because the size of the alphabet is constant (26 for lowercase English letters).

- **Space Complexity**: \( O(26) \) or \( O(1) \), since the hashmap stores character frequencies, and there are at most 26 different characters (if the string contains only English letters).

### Optimizations:

The code is quite optimized for this problem. However, we could further optimize it by:

- Using an array instead of a hashmap if the character set is known to be limited (e.g., only uppercase or lowercase English letters).
- Initializing `ans` to 0 instead of `Integer.MIN_VALUE`, since the minimum possible answer is 0, not a negative number.

Here is a slightly optimized version of the function using an array:

```java
public int characterReplacement(String s, int k) {
    int i = 0;
    int[] count = new int[26]; // Assuming only uppercase English letters
    int maxFreq = 0;
    int ans = 0;
    for (int j = 0; j < s.length(); j++) {
        maxFreq = Math.max(maxFreq, ++count[s.charAt(j) - 'A']);
        while ((j - i + 1) - maxFreq > k) {
            count[s.charAt(i) - 'A']--;
            i++;
        }
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}
```

This version assumes that `s` contains only uppercase English letters. If that's not the case, we would need to adjust the array size and the indexing accordingly.
 */
