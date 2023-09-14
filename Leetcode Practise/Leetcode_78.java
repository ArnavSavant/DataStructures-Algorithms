import java.util.ArrayList;
import java.util.List;

public class Leetcode_78 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer("");
        powerSet(nums, sb, ans, nums.length);
        return ans;
    }

    private void powerSet(int nums[], StringBuffer sb, List<List<Integer>> ans, int n) {
        if (sb.length() == n) {
            int key = Integer.parseInt(sb.toString());
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if ((key & 1) == 1) {
                    temp.add(nums[n - 1 - i]);
                }
                key = key >> 1;
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        sb.append('0');
        powerSet(nums, sb, ans, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('1');
        powerSet(nums, sb, ans, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
/*
Let's break down the code step by step.

### Problem:
Generate all subsets (also called the power set) of a given set. The given set is represented as an array of integers.

### Idea:
The approach being taken in this code is rooted in a binary representation. Think of each number in the input array `nums` as either being present (1) or not present (0) in a subset. If `nums` has length `n`, then there are `2^n` possible subsets. The code is essentially generating binary numbers from `0` to `2^n - 1` and for each binary number, interpreting 1s as "include this number in the subset" and 0s as "exclude this number."

### How the code works:
1. **Initialization**: A list `ans` is created to store all subsets. The `powerSet` function is then called with the current state of the buffer `sb`, which is initially empty.
  
2. **Recursion - `powerSet` Function**: 
   - If the length of the buffer `sb` equals `n` (the length of the input array `nums`), then it means that a binary combination of numbers is ready to be processed. The buffer contains a sequence of 1s and 0s representing inclusion/exclusion of the numbers from `nums` in the current subset.
   - The buffer `sb` is then converted to an integer, which represents a key.
   - For every bit in the key:
     - If the bit is 1, the corresponding number from `nums` is added to the temporary list `temp`.
     - The key is then right-shifted to check the next bit.
   - After processing all bits, the temporary list `temp` represents a subset, which is added to the final answer list `ans`.
   - If the length of the buffer `sb` is not `n`, then:
     - Append '0' to `sb` and recurse, which represents the exclusion of the current number.
     - Remove the last character from `sb`.
     - Append '1' to `sb` and recurse, which represents the inclusion of the current number.
     - Again, remove the last character from `sb` to backtrack.

### Why it works:
1. **Binary Representation**: Using a binary representation (sequence of 0s and 1s) to signify the presence or absence of numbers is intuitive. The binary number `001` would mean that only the last number of `nums` is present in the subset, for instance.
  
2. **Recursion & Backtracking**: The recursive approach ensures that all possible combinations of 0s and 1s are generated for the buffer `sb`. By appending '0' or '1' and then backtracking (removing the appended character), all possible subsets are covered.

3. **Bit Manipulation**: The use of bitwise operations (`key & 1` to check the least significant bit and `key = key >> 1` to right shift) allows for efficient checking and processing of the binary representations.

### Conclusion:
This method is a clever use of binary numbers and bit manipulation to generate all possible subsets of a given set. The recursion ensures completeness, and the binary approach ensures efficiency and simplicity.
 */
