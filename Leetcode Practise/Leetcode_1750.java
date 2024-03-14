public class Leetcode_1750 {
    public int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                char x = s.charAt(i);
                while (s.charAt(i) == x && i < j) {
                    i++;
                }
                while (s.charAt(j) == x && i < j) {
                    j--;
                }
            } else {
                break;
            }
        }
        if (s.charAt(i) == s.charAt(j)) {
            if (i == j) {
                return 1;
            } else {
                return 0;
            }
        }
        return j - i + 1;
    }
}
/*
The `minimumLength` method calculates the minimum length of a string after repeatedly removing identical characters from both ends of the string. This removal process continues until there are no identical characters at both ends or the string becomes empty.

### Algorithm

1. **Initialization**: Two pointers, `i` (starting from the beginning of the string) and `j` (starting from the end of the string), are used to traverse the string from both ends towards the center.

2. **Character Removal Loop**:
   - While `i < j`, check if the characters at the current positions of `i` and `j` are the same.
   - If they are the same, store the character in a variable `x`, and increment `i` to skip all identical characters at the beginning, and decrement `j` to skip all identical characters at the end.
   - If `i` and `j` point to different characters, the loop breaks, as no more identical characters can be removed from both ends simultaneously.

3. **Final Check**:
   - If, after exiting the loop, `i` equals `j` and the characters at positions `i` and `j` are the same, this means there's only one character left, so the minimum length is `1`.
   - If `i` equals `j` but the condition to check for identical characters fails due to the loop's condition, the loop might not account for the case where only one character is left. Thus, ensure the method correctly handles strings reduced to a single character or empty.
   - Calculate the remaining length of the string as `j - i + 1` to account for the cases where the loop exits because `i < j` condition becomes false, or different characters are found.

### Correction

The final check to determine if `s.charAt(i) == s.charAt(j)` when `i == j` is redundant and may lead to incorrect results, especially for strings that are reduced to a single character, as the check assumes additional conditions not required by the problem statement. Here's the corrected and simplified final part:

```java
return j - i + 1;
```

This adjustment directly returns the length of the remaining string, correctly handling all cases, including when the string is reduced to a single character or becomes empty.

### Time and Space Complexity

- **Time Complexity**: O(n), where `n` is the length of the input string `s`. In the worst case, the method iterates over each character of the string at most twice.
  
- **Space Complexity**: O(1), as the algorithm uses a fixed amount of space regardless of the input size.

### Summary

The `minimumLength` method effectively finds the minimum length of a string after removing pairs of identical characters from both ends. The use of two pointers facilitates an efficient linear scan, ensuring the method processes each character of the string optimally with minimal space overhead.
 */