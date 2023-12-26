import java.util.HashMap;
import java.util.Map;

public class Leetcode_1358 {
    public int numberOfSubstrings(String s) {
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        while (j < s.length()) {
            if (mp.containsKey(s.charAt(j))) {
                mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            } else {
                mp.put(s.charAt(j), 1);
            }
            if (mp.size() == 3) {
                while (mp.size() == 3 && i <= j) {
                    count = count + (s.length() - j);
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) {
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return count;
    }
}
/*
Certainly! The provided code is a Java function that calculates the number of substrings within a given string `s` that contain all three unique characters 'a', 'b', and 'c' at least once. Let's break down each component of this function to understand its logic, intuition, why it works, and its complexity.

### Logic and Intuition:

The function utilizes a two-pointer approach with a sliding window mechanism and a hashmap to keep track of the frequency of each character within the current window. Here's the step-by-step logic:

1. **Initialization**:
    - Two pointers `i` and `j` are initialized at the start of the string, representing the start and end of the current window, respectively.
    - A variable `count` is initialized to keep track of the number of valid substrings.
    - A hashmap `mp` is created to store the frequency of each character within the current window.

2. **Sliding Window**:
    - The window is expanded by moving the `j` pointer to the right, adding characters to the window until all three characters 'a', 'b', and 'c' are included.
    - The frequency of each character is updated in the hashmap as the window expands.

3. **Checking Validity**:
    - When the window contains all three unique characters (`mp.size() == 3`), this indicates a valid window from which we can derive substrings.

4. **Counting Substrings**:
    - For each valid window, we add `s.length() - j` to `count`. This is because if we have a valid window ending at `j`, then all substrings starting from `i` to `j` and extending to the end of the string will also be valid.

5. **Shrinking the Window**:
    - After counting the valid substrings for the current window, we shrink the window from the left by moving the `i` pointer to the right until the window no longer contains all three characters.
    - As we remove characters from the window, we decrement their frequency in the hashmap and remove them from the hashmap if their frequency drops to zero.

6. **Continuation**:
    - The process continues, expanding and shrinking the window, until the `j` pointer reaches the end of the string.

7. **Return Value**:
    - The function returns the total count of valid substrings.

### Why it Works:

- The algorithm works because it systematically expands the window to include all three characters and then shrinks it to exclude the first occurrence of the first character, counting all possible substrings that can be formed from each valid window. This ensures that all substrings are counted without duplication.

### Complexity:

- **Time Complexity**: The function has a linear time complexity of \( O(n) \), where \( n \) is the length of the string `s`. Although there is a nested loop, each character is added to and removed from the window at most once, resulting in a linear traversal over the length of the string.
  
- **Space Complexity**: The space complexity is \( O(1) \) because the hashmap `mp` stores only three characters 'a', 'b', and 'c' regardless of the size of the input string. Thus, the space used by the hashmap does not grow with the input size.

In summary, the algorithm is an efficient way to count the number of substrings containing all unique characters 'a', 'b', and 'c', utilizing a sliding window approach with a hashmap for frequency tracking, and its linear time complexity makes it suitable for large strings.
 */
