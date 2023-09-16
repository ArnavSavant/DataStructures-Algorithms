import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void solve(List<List<Integer>> ans, List<Integer> temp, int[] candidates,
            int target, int ind) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            solve(ans, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
/*
Alright, the code you've provided is trying to find all unique combinations in the array `candidates` where the numbers sum up to a given target. It is using a classic depth-first search (DFS) approach combined with backtracking to explore the possible combinations and find the ones that meet the criteria. Let's break down the logic step-by-step:

### Function `combinationSum2`:
1. **Initialization**:
   - The output list `ans` will store the result.
   - The input array `candidates` is sorted to make the further steps efficient.

2. **DFS Call**:
   - The `solve` method is called initially, starting from the first index.

3. **Return the Answer**:
   - Finally, the result `ans` is returned.

### Function `solve`:
This is a recursive function designed to explore the possible combinations:

1. **Base Condition**:
   - If `target == 0`, a valid combination is found. Hence, `temp` is added to `ans`.

2. **DFS Traversal**:
   - Iterate over the array starting from the `ind` (passed as an argument to the function).
     - If the current number is the same as the previous number and the current index isn’t the starting index `ind`, skip the current number. This step ensures uniqueness in the answer as repeating a number can lead to duplicate combinations.
     - If the current number is greater than the `target`, we break out of the loop. This is where sorting helps. If `candidates[i]` is greater than `target`, then certainly `candidates[i+1], candidates[i+2], ...` will also be greater than `target`.

3. **Backtracking**:
   - Add the current number to the `temp` list.
   - Recursive call to `solve` with a reduced target (subtracting the current number from target) and starting index moved to the next position (`i+1`).
   - Once returned from the recursive call, remove the last number from `temp`. This step is crucial for backtracking, as it undoes the change for the next iteration, effectively exploring all possible combinations.

### Intuition:
Imagine you're trying to fit pieces (numbers) into a puzzle (target sum). You try each piece in order. If it doesn't fit, you move to the next piece. If it fits, you keep it and look for the next piece to fit the remaining puzzle space (remaining target sum). If you find that even after fitting some pieces, the remaining puzzle space can't be filled by the pieces left, you backtrack – you remove the last fitted piece and continue your search. The sorting step makes it efficient by ensuring that once you find a piece too large for your puzzle, all the following pieces are also too large.

### Why It Works:
1. **Depth-First Search**: This recursive approach tries all possible combinations, ensuring that all valid combinations are considered.
   
2. **Backtracking**: By adding and subsequently removing elements from the `temp` list, the function can explore different combinations without having to create entirely new lists for each possibility.
   
3. **Sorting & Pruning**: Sorting allows us to skip over numbers that are duplicates (ensuring unique combinations) and to break out of unnecessary loops when the current number is greater than the target.

Together, these techniques ensure the algorithm is both comprehensive (finds all valid combinations) and efficient (avoids unnecessary work).
 */
