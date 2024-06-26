import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) { // window length
            int left = 0;
            int right = left + i;
            while (right < n) { // sliding the window
                String temp = s.substring(left, right + 1);
                if (set.contains(temp)) {
                    dp[left][right] = true;
                } else {
                    for (int k = left; k < right; k++) { // checking possible partitions
                        if (dp[left][k] && dp[k + 1][right]) {
                            dp[left][right] = true;
                        }
                    }
                }
                left++;
                right++;
            }
        }
        return dp[0][n - 1];
    }
}
/*
 * Alright, let's break down the given code, which is aimed to solve the
 * "Word Break" problem.
 * 
 * ### Problem Statement:
 * Given a non-empty string `s` and a dictionary `wordDict` containing a list of
 * non-empty words, determine if `s` can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * ### Logic and Intuition:
 * 
 * The main idea here is to leverage backtracking to try all possibilities. The
 * code tries to break the string `s` into prefixes and checks if each prefix
 * exists in the `wordDict`. If a prefix exists, the algorithm then checks the
 * remaining part of the string recursively.
 * 
 * 1. **Dictionary Representation**:
 * - The `wordBreak` function first creates a `wordSet` from the `wordDict`.
 * It's used to quickly check if a substring of `s` is present in the
 * dictionary. A hashmap is chosen for its O(1) time complexity for lookup
 * operations.
 * 
 * 2. **Base Case**:
 * - The `backtrack` function is a recursive function that checks if the string
 * `s` starting from index `ind` can be segmented into dictionary words.
 * - The base case is when `ind` equals the length of the string `s`. This means
 * we have successfully segmented the entire string using words from the
 * dictionary.
 * 
 * 3. **Backtracking Loop**:
 * - Starting from the index `ind`, the code checks every possible substring of
 * `s`.
 * - If a substring (from `ind` to `i`) is found in the dictionary (`wordSet`),
 * it means we can break the string there. We then recursively try to break the
 * remaining part of the string (from `i` to the end). If the recursive call
 * returns true, it means the remaining part can also be broken using dictionary
 * words, and so we return true.
 * - If no break point is found, we eventually return false.
 * 
 * ### Why This Code Works:
 * 
 * The code systematically checks each possible way the string can be segmented:
 * 
 * 1. **Prefix Checking**: For every position in the string, it checks if the
 * prefix (substring from the start to that position) is a valid word.
 * 
 * 2. **Recursive Exploration**: If a valid word (prefix) is found, it then
 * recursively checks if the remaining string can also be broken down. This
 * recursive nature ensures that every possible segmentation is explored.
 * 
 * 3. **Efficient Lookup**: The hashmap (`wordSet`) ensures that word lookup
 * operations are fast (O(1)).
 * 
 * However, it's worth noting that while this solution will work, it can be
 * quite inefficient for certain inputs due to repeated calculations. This is
 * where memoization can come into play to store already computed results for
 * certain string indices, making the algorithm much faster and ensuring each
 * subproblem is computed only once.
 */
