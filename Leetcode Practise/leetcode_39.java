import java.util.ArrayList;
import java.util.List;

public class leetcode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();

        solve(ans, temp, candidates, target, 0);
        return ans;
    }

    private void solve(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int ind) {
        if (ind == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (candidates[ind]<=target) {
            temp.add(candidates[ind]);
            solve(ans, temp, candidates, target - candidates[ind], ind);
            temp.remove(temp.size() - 1);
        }
        solve(ans, temp, candidates, target, ind+1);
    }
}
/*
Certainly! This code is an example of a backtracking solution to the combination sum problem. The problem is: given a set of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum up to `target`. The same repeated number may be chosen from `candidates` an unlimited number of times.

Let's dive into the logic and intuition:

### Logic and Intuition:

1. **Start and Initialization**:
   - `combinationSum` initializes an empty list `ans` to store the answer and a temporary list `temp` to keep track of the current combination. It then calls the recursive `solve` function to start the exploration.

2. **Exploration (Backtracking)**:
   - The function `solve` recursively explores all combinations of candidate numbers. The parameter `ind` represents the current index in the `candidates` array.
   - First, we check if we've already processed all candidates (`ind == candidates.length`). If we have and the `target` has been reduced to 0, it means the current combination `temp` sums up to the original target, so we add it to our answer `ans`.
   - Next, we check if the current candidate can be included in the combination without exceeding the target (`candidates[ind]<=target`). If so:
     - We add the current candidate to `temp`.
     - We recursively call `solve` reducing the `target` by `candidates[ind]` and keeping `ind` the same. This allows the same number to be used again.
     - After exploring this path, we backtrack by removing the last element from `temp`.
   - Finally, we also need to explore the path where the current candidate is not included in the combination. This is achieved by calling `solve` and simply increasing `ind` by 1 without modifying `target`.

### Why This Code Works:

The strength of this code is in its recursive structure which embodies the essence of backtracking.

1. **Choice**: At every number in `candidates`, you have two choices:
   - Include the number in the current combination (and potentially again since repetition is allowed).
   - Don't include the number and move to the next.

2. **Constraints**: The code ensures you never add a combination that doesn't sum up to the target. It also ensures you don't consider a number if including it will exceed the target (`candidates[ind]<=target` check).

3. **Goal**: The base case (`ind == candidates.length`) checks if we've formed a valid combination and adds it to our answer.

Backtracking often follows this pattern of making a choice, then recursively exploring, and finally undoing the choice (to backtrack). This code follows this pattern efficiently, ensuring that all possible combinations are explored without any redundant checks or repetitions.

In summary, this solution uses backtracking to explore all potential combinations, ensuring at each step that we adhere to our constraints, and when we reach our goal, it captures the valid combination.
 */
