public class Leetcode_14 {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].compareTo(commonPrefix) < 0) {
                commonPrefix = strs[i];
            }
        }
        String ans = "";
        int low = 0;
        int high = commonPrefix.length() - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (isPrefixPossible(strs, commonPrefix.substring(0, mid + 1))) {
                ans = commonPrefix.substring(0, mid + 1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPrefixPossible(String[] strs, String substring) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].indexOf(substring) != 0) {
                return false;
            }
        }
        return true;
    }
}

/*
Ah, this is a fine blend of two exquisite algorithms: the binary search and the common string prefix extraction. Let's embark on this journey of understanding this marvelous piece of code.

## Purpose of the Code:
This code aims to find the longest common prefix (LCP) among an array of strings. The longest common prefix for a pair of strings is the longest initial segment (or prefix) that's shared between them. When comparing multiple strings, the LCP is the longest prefix shared by all of them.

## Logic and Intuition:

**1. Pre-selection of `commonPrefix`:**
   - At first, we take the shortest string from the array, which is determined by the `compareTo` method. The rationale behind this is simple: the LCP can't be longer than the shortest string in the array since all strings must have this prefix.
   
**2. Binary Search Approach:**
   - The real beauty of this solution is its binary search mechanism applied to the string's characters.
   - Given that the maximum possible LCP is the shortest string (`commonPrefix`), we try to determine the actual LCP by evaluating the mid of this string. 
   - If the mid of `commonPrefix` is a valid prefix for all strings, then perhaps there's a longer prefix we haven't yet considered, so we shift our binary search to the right (i.e., consider the next half of `commonPrefix`). 
   - Otherwise, if the mid isn't a valid prefix, then the actual LCP is definitely shorter, so we move our search to the left (i.e., consider the previous half).

**3. Checking the Prefix Validity (`isPrefixPossible`):**
   - This function checks if a given substring is a valid prefix for all the strings in the array.
   - If any string doesn't start with the substring, it immediately returns `false`.

## Step by Step Explanation:

1. **Initial Selection:**
   - Assume the first string as the `commonPrefix`.
   - Loop through the array and find the shortest string, which updates the `commonPrefix`.
   
2. **Binary Search:**
   - Initialize `low` to 0 and `high` to the last index of `commonPrefix`.
   - Keep searching while `low` is less than or equal to `high`:
     - Calculate `mid` index.
     - Check if the prefix until `mid` (inclusive) is a common prefix for all strings.
       - If true: update `ans` and shift the search to the right.
       - If false: reduce the search to the left.
   
3. **Return the Longest Common Prefix:**
   - After the binary search ends, the string `ans` contains the longest common prefix, which is returned.

In essence, this code marries the linear process of checking a prefix with the logarithmic process of binary search, making the solution more efficient than checking each possible prefix linearly.
 */
