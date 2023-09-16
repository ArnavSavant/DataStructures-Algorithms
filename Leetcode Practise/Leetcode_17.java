import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> mp = new HashMap<Character, String>();
        mp.put('1', "");
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        solve(ans, mp, digits, new StringBuffer(), 0);
        return ans;
    }

    public void solve(List<String> ans, Map<Character, String> mp, String digits, StringBuffer sb, int ind) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String value = mp.get(digits.charAt(ind));
        for (int i = 0; i < value.length(); i++) {
            sb.append(value.charAt(i));
            solve(ans, mp, digits, sb, ind + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
/*
Alright! Let's discuss the given code, which aims to provide the letter combinations of a phone number.

### Context:
When you have a traditional telephone keypad, each digit is associated with a set of letters:

```
1:     2:abc  3:def
4:ghi  5:jkl  6:mno
7:pqrs 8:tuv  9:wxyz
```

Given a digit string, the task is to return all possible letter combinations that the number could represent. 

### Logic and Intuition:

#### 1. `letterCombinations` function:

1. **Initialization**: A list `ans` is initialized to store the final letter combinations.
2. **Base Check**: If the `digits` string is empty, the function returns an empty list.
3. **Mapping Initialization**: A `HashMap` `mp` is initialized to map each digit to its corresponding letters.
4. **Recursive Call**: The recursive function `solve` is called to fill `ans` with the possible combinations.

#### 2. `solve` function (Recursion & Backtracking):

This function uses both recursion and backtracking to generate the combinations:

1. **Base Case**: If the length of the `StringBuffer` `sb` (which is being used to form the current combination) is equal to the length of `digits`, then a valid combination is formed, and it's added to the `ans`.
2. **Recursive Calls**:
   - Fetch the letters associated with the current digit (using `ind` to track our position in the `digits` string).
   - For each letter in the fetched set of letters, do:
       * Append the letter to `sb`.
       * Recursively call `solve` for the next digit.
       * Remove the last added letter (Backtrack) to try the next possibility.

### Why the Two-Pointer Technique Works:
This code works because it systematically tries every possible combination of letters for the provided digits. Here's a breakdown:

1. **Systematic Traversal**: The recursive approach ensures that for every digit in the input, every associated letter is tried out in combination with every letter of the subsequent digits.

2. **Backtracking**: After trying out a letter for a particular digit, the code "backs out" or "undoes" that choice (by removing the last appended character) to try the next letter. This ensures that all possible paths or combinations are explored.

3. **Depth-first Search (DFS)**: This approach can be seen as a DFS on a tree where each level of the tree represents a digit, and each branch at a level represents a letter associated with that digit. The recursive solution explores each branch fully (i.e., each combination) before backtracking.

4. **Efficiency**: Instead of iterative loops, recursion provides a clean and efficient way to generate combinations for varying lengths of digits.

### Conclusion:
The provided solution uses a depth-first traversal approach combined with backtracking to efficiently and systematically generate all possible letter combinations for a given set of digits. The use of a map (`HashMap`) makes it easy to fetch associated letters, and the recursive method ensures all combinations are generated.
 */