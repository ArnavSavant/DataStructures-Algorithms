import java.util.ArrayList;
import java.util.List;

public class Leetcode_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), new StringBuilder(), 0, s);
        return ans;
    }

    public void solve(List<List<String>> ans, List<String> temp, StringBuilder sb, int ind, String s) {
        if (ind == s.length()) {
            for (String x : temp) {
                if (!isPalindrome(x)) {
                    return;
                }
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            sb.append(s.charAt(i));
            temp.add(sb.toString());
            solve(ans, temp, new StringBuilder(), i + 1, s);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
/*
The provided code aims to partition a string into palindrome substrings and return all possible such partitions.

Let's break down the code and understand its logic, intuition, and functionality.

### Code Logic and Intuition:

**1. `partition` function:**
The primary function initializes the result list `ans` and calls the helper function `solve` to fill it with the desired partitions.

**2. `solve` function:**
This function is a recursive one that tries to partition the given string into palindrome substrings.

- **Base Case**: If `ind` is equal to the length of the string `s`, it implies we've iterated through the entire string. The current temporary partition `temp` is then checked. If all substrings inside `temp` are palindromes, `temp` is added to the result `ans`.
  
- **Recursive Case**: From the current index `ind` to the end of the string, the function tries to create potential palindrome substrings by incrementally appending characters from `s` to `sb`. After appending each character, it adds the current content of `sb` (a potential palindrome substring) to the temporary partition `temp` and makes a recursive call to try and form the next partition.

  Following the recursive call, it backtracks by removing the last added substring from `temp`. This backtracking ensures we explore all possible partitions.

**3. `isPalindrome` function:**
This helper function checks whether a given string is a palindrome by using the two-pointer technique. It starts with pointers at the two ends of the string and moves them toward each other, comparing characters at every step. If all characters match, it's a palindrome.

### Why This Code Works:
1. **Recursive Exploration**: The code explores all possible partitions of the string because, for every index, it tries to form all potential substrings that start at that index and checks if they can be part of a valid palindrome partition.

2. **Backtracking**: After exploring each potential substring starting from an index, it reverts the last change (by removing the last substring from `temp`). This ensures that the code doesn't get stuck on a single path and explores all possible combinations.

3. **Efficient Palindrome Check**: The palindrome check is O(n) for a string of length n, which is efficient. This check ensures only valid palindrome partitions are added to the result.

4. **Complete Exploration**: The code ensures a thorough examination by running until the index (`ind`) reaches the string's end, at which point it validates the current partition.

In summary, the code uses a combination of recursive exploration and backtracking to generate all possible palindrome partitions for a given string. The logic ensures that all combinations are explored, and the palindromic nature of substrings is efficiently validated, ensuring the correctness of the solution.
 */