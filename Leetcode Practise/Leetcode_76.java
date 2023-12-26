import java.util.HashMap;
import java.util.Map;

public class Leetcode_76 {
    public String minWindow(String s, String t) {
        String ans = "";
        int minWindow = Integer.MAX_VALUE;
        Map<Character, Integer> bucket = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (bucket.containsKey(t.charAt(i))) {
                bucket.put(t.charAt(i), bucket.get(t.charAt(i)) + 1);
            } else {
                bucket.put(t.charAt(i), 1);
            }
        }
        int count = bucket.size();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (bucket.containsKey(s.charAt(j))) {
                bucket.put(s.charAt(j), bucket.get(s.charAt(j)) - 1);
                if (bucket.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            if (count > 0) {
                j++;
            } else if (count == 0) {
                while (count == 0) {
                    minWindow = Math.min(minWindow, j - i + 1);
                    if (minWindow == j - i + 1) {
                        ans = s.substring(i, j + 1);
                    }
                    if (bucket.containsKey(s.charAt(i))) {
                        bucket.put(s.charAt(i), bucket.get(s.charAt(i)) + 1);
                        if (bucket.get(s.charAt(i)) > 0) {
                            i++;
                            count++;
                        } else {
                            i++;
                            minWindow = Math.min(minWindow, j - i + 1);
                            if (minWindow == j - i + 1) {
                                ans = s.substring(i, j + 1);
                            }
                        }
                    } else {
                        i++;
                        minWindow = Math.min(minWindow, j - i + 1);
                        if (minWindow == j - i + 1) {
                            ans = s.substring(i, j + 1);
                        }
                    }
                }
                j++;
            }
        }
        return ans;
    }
}
/*
The provided Java function `minWindow` is designed to solve the "Minimum Window Substring" problem, a classic example of a sliding window problem with variable window size. The goal is to find the smallest substring in `s` that contains all the characters in `t`.

### Logic and Intuition:

1. **Character Frequency Map (`bucket`)**:
   - First, the function creates a frequency map (`bucket`) for all characters in `t`, keeping track of how many times each character appears in `t`.

2. **Two-Pointer Technique**:
   - The function uses two pointers `i` and `j` to create a sliding window that expands and contracts over the string `s`. Initially, both `i` and `j` are at the start of `s`.

3. **Expanding the Window**:
   - The window expands by moving `j` to the right. For each character that `s` and `t` share, the function decrements the count in the `bucket`.
   - When the count for a character in the `bucket` reaches zero, it means we have enough occurrences of that character in the current window to satisfy the requirement from `t`. The `count` variable is decremented to reflect that one less character's requirement is now satisfied.

4. **Shrinking the Window**:
   - Once all characters' requirements are satisfied (`count` is zero), the function tries to shrink the window from the left by moving `i` to the right, while maintaining the satisfaction of all character requirements.
   - If, after removing a character from the left, the character's frequency in `bucket` is greater than zero, it means the current window no longer satisfies all requirements, so the window can no longer shrink. In this case, `count` is incremented since we now need one more of that character for a valid window.

5. **Updating Minimum Window**:
   - Each time the window shrinks or expands, the function checks if the current window size is the smallest seen so far that satisfies all character requirements.
   - If it is, the function updates `minWindow` with the new size and `ans` with the current window substring.

6. **Continuation**:
   - The process continues until `j` reaches the end of `s`.

### Why It Works:

The algorithm works because it maintains a dynamic window that only includes the necessary characters to satisfy the requirements of `t`. By using a count of how many character requirements are satisfied, the function knows when to expand or shrink the window. The `bucket` serves as a way to keep track of whether the current window has enough of each character from `t`.

### Complexity:

- **Time Complexity**: \( O(N + M) \), where \( N \) is the length of string `s` and \( M \) is the length of string `t`. This is because each character in `s` is visited at most twice - once when expanding the window and once when shrinking it - and creating the frequency map for `t` takes \( O(M) \) time.

- **Space Complexity**: \( O(M) \), where \( M \) is the length of string `t`. The extra space is used for the frequency map (`bucket`) which contains at most all unique characters of `t`. If the character set is fixed (like ASCII), this can also be considered \( O(1) \) space complexity.

### Optimization:

The code could potentially be optimized in terms of readability and eliminating redundant code:

- The logic for updating the `minWindow` and `ans` is repeated multiple times and could be refactored into a separate method or simplified to reduce redundancy.
- Additionally, the updates to `minWindow` and `ans` can be made only when the window is shrinking since this is the only time the window size can be the smallest to meet all character requirements.

Overall, the algorithm is efficient for the problem it is intended to solve, using the sliding window technique optimally.
 */