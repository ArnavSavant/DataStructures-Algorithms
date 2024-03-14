public class Leetcode_28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int[] lps = computeLPSArray(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    private int[] computeLPSArray(String needle) {
        int[] lps = new int[needle.length()];
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }
        return lps;
    }
}
/*
The provided code is an implementation of the Knuth-Morris-Pratt (KMP) algorithm for substring search. This algorithm allows for efficient searching of a "needle" (substring) within a "haystack" (string). It's particularly efficient because it avoids redundant checking of characters in the haystack that are already known not to match the needle, leveraging previously gained knowledge during the search process.

### Understanding the `strStr` Method:

1. **Base Case Check**: If `needle` is empty, it immediately returns 0, indicating that an empty string is found at the beginning of any string, including an empty haystack.

2. **Compute LPS Array**: It computes the Longest Prefix Suffix (LPS) array for the `needle`. The LPS array represents the longest proper prefix which is also a suffix. A proper prefix is a prefix that is not equal to the string itself. This array is used to skip characters while matching, thus reducing the number of comparisons.

3. **Search Process**:
   - Two pointers `i` (for `haystack`) and `j` (for `needle`) are used to traverse the strings.
   - When characters at `i` and `j` match, both pointers are advanced.
   - If `j` reaches the length of `needle`, it means the entire needle has been found within the haystack, returning the start index of the match (`i - j`).
   - If a character doesn't match and `j` is not at the beginning of `needle`, it uses the LPS array to decide the next position of `j` without reducing `i`. This essentially skips comparing parts of the needle that have already been matched.
   - If no match is found and `j` is at the start, it simply advances `i`.

4. **Return Value**: If the needle is not found in the haystack, it returns -1.

### Understanding the `computeLPSArray` Method:

- The method initializes an LPS array of the same length as `needle`, starting with an LPS value of 0 for the first character.
- It uses two pointers: `i` (starts from 1) and `length` (starts from 0) to compare characters in the `needle`.
- When characters at `i` and `length` match, it means a longer prefix which is also a suffix has been found, so it increments `length` and assigns this value to `lps[i]`, then moves to the next character by incrementing `i`.
- If there is a mismatch, it uses the LPS array to find the next position of `length`. If `length` is not at the start, it moves to `lps[length - 1]`. This step essentially skips over the portion of the needle that can be assumed to match based on previous matches, thus not starting the comparison from the beginning.
- This process continues until the entire needle has been scanned to fill the LPS array.

### Logic and Intuition:

The key intuition behind KMP is that when a mismatch occurs at some point after a series of matches, instead of starting the search from the next character of the original start, or the next character in the needle, KMP uses the information from the LPS array to skip over the known matching part of the needle. This significantly reduces the number of comparisons, especially in cases where the pattern has repeating subpatterns.

### Time Complexity:

- Computing the LPS array takes O(m) time, where m is the length of the needle.
- The main search operation in the `strStr` method also takes O(n) time in the worst case, where n is the length of the haystack. This is because, despite the inner while loop, each character in the haystack is visited at most twice (once by `i` and once possibly by the `j` reset using the LPS array).

### Space Complexity:

- The space complexity is O(m) due to the storage of the LPS array.

In conclusion, the KMP algorithm offers a more efficient way to perform substring search compared to the naive approach, especially for patterns with repeating subpatterns, by avoiding unnecessary comparisons.
 */