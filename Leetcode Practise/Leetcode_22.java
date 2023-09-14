import java.util.ArrayList;
import java.util.List;
public class Leetcode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        StringBuffer sb = new StringBuffer("");
        solve(ans,0,0,sb,n);
        return ans;
    }

    private void solve(List<String> ans, int open, int close, StringBuffer sb, int n) {
        if(sb.length()==2*n) {
            ans.add(sb.toString());
            return;
        }
        if(open<n) {
            sb.append('(');
            solve(ans, open+1, close, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open) {
            sb.append(')');
            solve(ans, open, close+1, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
/*
Alright, let's break down this code and understand its logic and intuition.

The given code is designed to generate all possible valid combinations of parentheses for a given integer `n`. By valid, we mean that each combination should open and close correctly. For example, for `n = 2`, the valid combinations are: `["(())", "()()"]`.

## Explanation:

### `generateParenthesis` function:
1. **Initialization**: 
   - The `ans` list will store the valid combinations.
   - The `StringBuffer sb` is initialized as an empty string and will be used to build combinations.
   
2. **Function Call**: 
   - It calls the `solve` function with the initial parameters to start building the combinations.

### `solve` function:

The real magic happens in the recursive `solve` function:

1. **Base Case**: If the length of the `sb` (StringBuffer) is `2*n`, it means we've generated a combination of parentheses. So, it is added to the `ans` list.

2. **Generate Open Parenthesis**:
   - Before adding an open parenthesis `'('`, we need to ensure we haven't exceeded the allowed number `n`. So, the check `if(open<n)` ensures we're within bounds.
   - If true, append an open parenthesis to `sb` and make a recursive call to `solve`, increasing the `open` count by 1.
   - After coming back from the recursive call, the last appended character is removed from `sb` (backtracking step) to try other possibilities.

3. **Generate Close Parenthesis**:
   - Before adding a close parenthesis `')'`, we need to ensure that the number of closed parentheses added so far is less than the open ones. This ensures validity. The check `if(close<open)` serves this purpose.
   - If true, append a close parenthesis to `sb` and make a recursive call to `solve`, increasing the `close` count by 1.
   - Again, after the recursive call, backtrack by removing the last appended character from `sb`.

## Intuition:
1. **Recursion & Backtracking**: The idea is to explore all possible combinations, and once you've explored a path, you backtrack to explore other paths.

2. **Constraints**: 
   - You should not add more open parentheses than the number `n`.
   - You should not add more close parentheses than open ones at any point, as it would render the combination invalid.

## Why this code works:
1. **Recursive Exploration**: The code exhaustively tries all possible combinations of parentheses using recursion.
2. **Constraints Handling**: The code ensures validity by checking constraints before adding any parenthesis.
3. **Backtracking**: After exploring a particular combination (path), it backtracks to the previous state and explores other possibilities. This ensures that all possible combinations are tried.

In essence, this approach guarantees that all valid combinations are generated because it systematically explores every possibility, adhering to the constraints of valid parentheses formation.
 */
