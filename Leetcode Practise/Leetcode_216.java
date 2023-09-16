import java.util.ArrayList;
import java.util.List;

public class Leetcode_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k, n, new ArrayList<>(), ans, 1);
        return ans;
    }

    private void solve(int k, int n, List<Integer> temp, List<List<Integer>> ans, int x) {
        if (temp.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = x; i <= 9; i++) {
            if (i <= n) {
                temp.add(i);
                solve(k, n - i, temp, ans, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
/*
Alright, let's unpack the provided code which is designed to solve a particular combination problem. The problem it's solving is to find all possible combinations of `k` numbers that add up to a number `n`. However, only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

### **High-Level Idea:**
The algorithm utilizes a backtracking approach to generate combinations. Backtracking is essentially an algorithmic-technique for solving problems recursively by trying to build a solution incrementally, solving one piece at a time, and removing those solutions that fail to satisfy the constraints of the problem at any point in time.

In the context of this problem:
- You start with an empty combination.
- For every number from 1 to 9, you attempt to add it to your current combination and proceed.
- If a combination reaches the desired sum `n` and has `k` numbers, you store it.
- If not, you backtrack by removing the last number and try the next one.

### **Function Breakdown:**

#### `combinationSum3(int k, int n)`:
- Initializes an empty list of lists to store valid combinations (`ans`).
- Calls the helper function `solve` to begin the backtracking process with an empty `temp` list starting from number 1.
- Returns the list of valid combinations.

#### `solve(int k, int n, List<Integer> temp, List<List<Integer>> ans, int x)`:
- **Base Case**: If the size of `temp` list reaches `k`, and the desired sum `n` has been achieved, a valid combination is found, and it's added to the `ans`.
- **Backtracking Loop**: From number `x` to 9, the function:
  - Checks if the current number `i` can be a part of a valid combination (i.e., `i` is less than or equal to `n` which ensures we're not going beyond the required sum).
  - Adds `i` to the current combination (`temp`).
  - Recursively calls `solve` for the next number.
  - Backtracks by removing the number `i` from `temp`.

### **Intuition and Why This Works:**
- **Exploring Possibilities**: The recursive approach ensures that every possible combination of numbers from 1 to 9 is tried.
- **Avoiding Repetitions**: By ensuring the next number added is greater than the last number added (using the `x` parameter), the algorithm avoids repetitions (e.g., [1, 2, 4] and [2, 1, 4]).
- **Pruning the Search**: If a number exceeds the required sum `n`, the loop breaks, ensuring that invalid paths are not further explored.
- **Backtracking**: This is the heart of the algorithm. After exploring with a number `i`, we backtrack by removing it and then try the next number. This ensures all combinations starting from 1, then from 2, and so on are explored.

By systematically exploring, pruning invalid combinations, and backtracking, the algorithm efficiently finds all unique combinations of `k` numbers that add up to `n`.
 */
