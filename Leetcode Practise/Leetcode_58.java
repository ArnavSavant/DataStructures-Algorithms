public class Leetcode_58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return length;
    }
}
/*
The `lengthOfLastWord` method aims to find the length of the last word in a string `s`. The approach you've provided attempts to trim the string to remove leading and trailing spaces and then iterate from the end of the string to count the length of the last word. However, there's a crucial step missing in your implementation, which is actually updating the `length` variable during the iteration. Let's correct and complete the method for it to function as intended.

### Corrected and Complete Method

Here's the revised version of the function:

```java
public int lengthOfLastWord(String s) {
    s = s.trim(); // Remove leading and trailing spaces
    int length = 0; // Initialize length counter for the last word
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ' ') {
            break; // Stop counting when the first space (from the end) is found
        }
        length++; // Increment the length for each character in the last word
    }
    return length; // Return the counted length of the last word
}
```

### Explanation

1. **Trim the String**: `s.trim()` is used to remove any leading or trailing spaces, ensuring that the counting doesn't get affected by spaces at the beginning or the end of the string.
   
2. **Initialize Length Counter**: `length` is set to 0 to start counting the length of the last word.

3. **Iterate Backwards Through the String**: Start from the last character and move backward:
   - **Character Check**: If a space character is encountered (`if (s.charAt(i) == ' ')`), it indicates the start of the string or the space after the last word, so the loop breaks.
   - **Increment Length**: For each non-space character, increment the `length` counter.

4. **Return the Result**: After the loop ends (either by encountering a space or reaching the beginning of the string), `length` will contain the size of the last word, which is then returned.

### Time and Space Complexity

- **Time Complexity**: O(n), where n is the length of the string. In the worst case, the entire string is iterated over backwards, which happens linearly relative to the size of the string.

- **Space Complexity**: O(1), since only a few additional variables (`length` and the space for the trimmed version of `s`) are used, which do not depend on the size of the input string.

### Conclusion

The corrected method now properly counts the length of the last word in the string by ensuring that the length counter is updated for each character of the last word encountered during the backward iteration. This approach efficiently handles strings with leading and trailing spaces and provides the desired functionality with optimal performance.
 */