public class Leetcode_81 {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[low]) {
                low++;
            }
            else if (nums[mid] == nums[high]) {
                high--;
            }
        }
        return false;
    }
}

/*
### Purpose:
The given code is a function that searches for a target value in a sorted and rotated array. If the target is found, it returns `true`, otherwise `false`.

### Logic & Intuition:

1. **Initialization**:
   - `low` and `high` pointers are initialized to the start and end of the array, respectively.

2. **Binary Search**:
   - The code uses a modified binary search. In a standard binary search, the array is divided into two halves, and based on the comparison with the middle element, one half is discarded. Here, due to the rotation, the array might have been shifted, so we need to handle that.

3. **Finding the Middle**:
   - `int mid = high - (high - low) / 2;` is equivalent to `int mid = (low + high) / 2;`. It calculates the middle index.

4. **Checking for Target**:
   - If the middle element is the target, we return `true`.

5. **Modified Binary Search Logic**:
   - If the left half (from `low` to `mid`) is sorted (`nums[mid] > nums[low]`):
     - Check if the target lies in this sorted half by comparing it with the `low` and `mid` values. If yes, move the `high` pointer to `mid - 1`. If not, move the `low` pointer to `mid + 1`.
   - If the right half (from `mid` to `high`) is sorted (`nums[mid] < nums[high]`):
     - Check if the target lies in this sorted half by comparing it with the `mid` and `high` values. If yes, move the `low` pointer to `mid + 1`. If not, move the `high` pointer to `mid - 1`.

6. **Handling Duplicates**:
   - If `nums[mid]` is equal to `nums[low]`, it's possible that there are duplicates. To handle this, we increment the `low` pointer.
   - Similarly, if `nums[mid]` is equal to `nums[high]`, we decrement the `high` pointer. This ensures that we're narrowing down our search space.

7. **End of Search**:
   - If the loop completes without finding the target, we return `false`.

### Complexity:

1. **Time Complexity**:
   - In the worst case (when there are many duplicates), the function might end up with a linear search, making the time complexity O(n).
   - In the best case (no duplicates and the target is found quickly), it's O(log n) due to the binary search.

2. **Space Complexity**:
   - The space complexity is O(1) since no additional space is used other than a few variables.

In summary, this function uses a modified binary search to find a target in a sorted and rotated array, taking into account possible duplicates. The rotation of the array adds a twist to the standard binary search, but the core logic remains the same.
 */
