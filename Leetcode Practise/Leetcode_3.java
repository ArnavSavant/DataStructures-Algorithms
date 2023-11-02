import java.util.HashMap;
import java.util.Map;

public class Leetcode_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (mp.containsKey(s.charAt(j))) {
                mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            } else {
                mp.put(s.charAt(j), 1);
            }
            if (mp.size() == j - i + 1) {
                ans = Math.max(ans, mp.size());
            } else if (mp.size() < j - i + 1) {
                while (mp.size() < j - i + 1) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) {
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}

/*
Alright, let's dive deep into the code! This code is an implementation of a sliding window approach to find the length of the longest substring without repeating characters in a given string `s`.

**Intuition:** 

If a string has all distinct characters, then the longest substring without repeating characters is the string itself. However, if the string has some repeating characters, we need to find a substring that does not have any repetition. A brute force approach would be to check every possible substring, but that would take a lot of time. The sliding window approach optimizes this by maintaining a "window" that represents the current substring we are examining. The window is defined by two pointers: `i` and `j`, which represent the start and end of the current window, respectively.

**Logic:** 

1. If the string is empty, return 0.
2. Create a hashmap `mp` to maintain the characters present in the current window and their frequency.
3. Start both pointers `i` and `j` at the beginning of the string.
4. The variable `ans` is used to store the maximum length of substring without repeating characters found so far.

**Inside the main loop:**

5. As we move the `j` pointer, if the character at `j` is already in the map, we increase its count; if it's not, we add it to the map with a count of 1.
6. After updating the map, we check if the size of the map (number of unique characters in our window) is equal to the size of the current window (`j - i + 1`). If they're equal, it means all characters in the window are unique. Update `ans` if the current window size is greater than `ans`.
7. If the size of the map is less than the window size, it implies that there is a repeating character in the window. We need to shrink the window from the left by moving the `i` pointer. As we move the `i` pointer, we decrease the count of the character at `i` in the map. If the count becomes 0, we remove that character from the map. We continue moving `i` until the size of the map is again equal to the size of the window.
8. Increment the `j` pointer and repeat the above steps.

**Why it works:** 

At each step, we either expand the window from the right or shrink it from the left. This guarantees that we inspect all possible windows of the string. The use of a hashmap allows us to keep track of the characters in the current window efficiently. By comparing the size of the hashmap and the window size, we can quickly determine whether the current window has all unique characters or not. 

The result `ans` gives us the size of the largest window (substring) we found with all unique characters.
 */