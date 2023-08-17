public class Leetcode_35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = high - (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if (target < nums[mid]) {
            return mid;
        }
        return mid + 1;
    }
}

/*
### Intuition:
The main intuition behind this code is to leverage the property of a sorted array. Instead of searching for the target sequentially (which would take O(n) time), we can use a divide-and-conquer approach to reduce the search space by half in each iteration. This is the essence of the binary search algorithm, which has a time complexity of O(log n).

### Logic:

1. **Initialization**:
   - `low` is initialized to 0, representing the start of the array.
   - `high` is initialized to `nums.length - 1`, representing the end of the array.
   - `mid` is initialized to -1, which will later store the middle index of the current search space.

2. **Binary Search Loop**:
   - The `while` loop runs as long as `low` is less than or equal to `high`, ensuring we don't overshoot our search space.
   - Inside the loop, `mid` is calculated as the average of `low` and `high`. The expression `high - (high - low) / 2` is equivalent to `(low + high) / 2` but avoids potential integer overflow.
   - There are three conditions checked based on the value at `nums[mid]`:
     - If `nums[mid]` is less than `target`, it means the target lies to the right of `mid`. So, we update `low` to `mid + 1`.
     - If `nums[mid]` is greater than `target`, it means the target lies to the left of `mid`. So, we update `high` to `mid - 1`.
     - If `nums[mid]` is equal to `target`, we've found the target in the array, and we return its index (`mid`).

3. **Post-loop Logic**:
   - If the loop exits without returning, it means the target is not present in the array. Now, we need to determine the correct position to insert the target.
   - If `target` is less than `nums[mid]`, it should be inserted at the `mid` position.
   - Otherwise, it should be inserted to the right of `mid`, so we return `mid + 1`.

### Example:
Consider the array `nums = [1, 3, 5, 6]` and `target = 5`.

- Initial values: `low = 0`, `high = 3`, `mid = -1`.
- First iteration: `mid = 1`, `nums[mid] = 3` which is less than `target`, so `low` becomes 2.
- Second iteration: `mid = 2`, `nums[mid] = 5` which is equal to `target`, so the function returns 2.

### Conclusion:
This code efficiently finds the position to insert a target value in a sorted array using the binary search algorithm. The binary search reduces the search space by half in each iteration, making it much faster than a linear search for large arrays.
 */
