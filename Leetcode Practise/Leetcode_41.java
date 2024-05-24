public class Leetcode_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctPos = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
/*
The `firstMissingPositive` function in your provided code is an efficient solution to a common problem in algorithm challenges: finding the smallest positive integer that is missing from an unsorted array. This function utilizes an in-place swap strategy to sort the elements (to an extent), aiming to place each number in its corresponding index position (i.e., the number 1 in index 0, 2 in index 1, etc.). This approach is often referred to as "index sort" or using the array itself as a hash table where the key is the index and the value is the element at that index.

### Algorithm Overview

1. **In-place Reordering**:
   - Traverse the array, and for each element, check if it is within the range `[1, n]` (where `n` is the length of the array) and not already in its correct position.
   - Perform swaps to move the element to its correct position (i.e., element `k` should be at index `k-1`).
   - This step ensures that if an integer `k` that is between 1 and `n` is in the array, it will be positioned at index `k-1`.

2. **Check for Missing Positive**:
   - After reordering, traverse the array again. The first index `i` where the value is not `i+1` is the smallest missing positive, because `i+1` would be the expected element at that position if all preceding positive integers were present.
   - Return `i+1` as the missing integer.

3. **All Present Case**:
   - If the loop completes without finding a discrepancy (i.e., every integer from `1` to `n` is in its correct position), the smallest missing integer is `n+1` since the array contains all integers from `1` to `n`.

### Time Complexity

- **O(n)**: Despite the nested appearance of the while-loop inside the for-loop, each element is moved at most once to its correct position. Thus, the operations involved still lead to a linear time complexity with respect to the number of elements in the array.

### Space Complexity

- **O(1)**: The algorithm operates in-place, using only a constant amount of extra space for variables used in the swap operations.

### Example Walkthrough

Consider the array `nums = [3, 4, -1, 1]`:
- During reordering:
  - The number 3 at index 0 is swapped to index 2.
  - The number -1 (out of desired range) does nothing.
  - The number 1 is swapped to index 0.
- The reordered array might look like `[1, 4, 3, -1]`.
- Post-reordering check reveals the number at index 1 is 4 (not 2), so the smallest missing positive is `2`.

### Conclusion

This function is a textbook implementation for this kind of problem, demonstrating a clever use of array indices as a natural hash map, which is particularly useful in scenarios where additional space usage is restricted. This approach is optimal for situations where the task is to find a missing positive integer in a constrained environment.
 */