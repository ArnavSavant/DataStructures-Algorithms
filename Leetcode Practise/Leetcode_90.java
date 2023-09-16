import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>(), solution);
        return solution;
    }

    public void solve(int nums[], int ind, List<Integer> list, List<List<Integer>> solution) {
        if (ind == nums.length) {
            if (!solution.contains(new ArrayList<>(list))) {
                solution.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[ind]);
        solve(nums, ind + 1, list, solution);
        list.remove(list.size() - 1);
        solve(nums, ind + 1, list, solution);
    }
}
/*
This code aims to find all possible subsets (or power set) of a given set of numbers with duplicate numbers included. It is an example of a recursive backtracking approach. Let's break down the logic, intuition, and operation of the code:

### 1. Logic & Intuition:
1. **Subsets With Duplicates**: If you were generating a power set for an array without duplicates, it would be straightforward, as every number has only two options: either be a part of the subset or not. But with duplicates, to avoid producing repeated subsets, you need to handle cases where you have repeated numbers.

2. **Backtracking**: It's a systematic way to iterate over all possible configurations. You make a choice, explore further choices, and then backtrack. Here, for each number, you decide whether to include it in the current subset or not. This is represented by the two recursive calls.

3. **Sorting**: Sorting the `nums` array ensures that duplicates are placed together. This way, when the recursion explores and adds subsets, it will add duplicates in sequence, making it easier to check for and avoid duplicate subsets.

### 2. How The Code Works:

1. **`subsetsWithDup` Function**:
   - Initializes the list `solution` that will store all subsets.
   - Sorts the `nums` array to make sure all similar numbers are adjacent.
   - Calls the recursive function `solve` starting at index `0`.

2. **`solve` Function**:
   - **Base Case**: If `ind` (index) is equal to `nums.length`, it means we've made decisions for all elements in `nums`. At this point:
     - If the current subset (list) is not already in the solution, we add it to the solution. This checks for duplicates.
     - The function returns after this.
     
   - **Including the current number in subset**: 
     - We add the number at index `ind` to the `list`.
     - We make a recursive call to `solve`, increasing the index (`ind + 1`), meaning we're moving to the next number and deciding whether to include it in the subset.
     - After exploring all possibilities with the current number included, we backtrack by removing the last number from the `list`.
     
   - **Excluding the current number from subset**:
     - Without adding the current number to the `list`, we make another recursive call to `solve` to explore possibilities without the current number.
     
3. **Duplicates Handling**: 
   - After sorting, all duplicate numbers are adjacent. When generating subsets, we'll either be including all of a particular duplicate number or none of them. This means that checking for duplicates in the solution becomes straightforward as similar subsets would have their numbers in the same order. The line `if (!solution.contains(new ArrayList<>(list)))` ensures that we're not adding duplicate subsets.

### 3. Points of Improvement:
This solution works, but it's not the most efficient due to the use of `solution.contains(new ArrayList<>(list))`, which in the worst case has a time complexity of O(2^n) for each check. This leads to a total worst-case time complexity of O(2^n * 2^n). More efficient approaches can handle duplicates without having to check every subset in the solution.

In conclusion, this code provides a backtracking approach to generate all possible subsets of a given array, accounting for potential duplicates by sorting the array and checking for duplicate subsets before adding to the solution.
 */
