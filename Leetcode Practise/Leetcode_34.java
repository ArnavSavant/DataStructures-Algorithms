public class Leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = firstOccurence(nums, target);
        ans[1] = lastOccurence(nums, target);
        return ans;
    }

    public int firstOccurence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public int lastOccurence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}

/*
### Overview:
The main function `searchRange` returns an array of two integers. The first integer is the index of the first occurrence of the target, and the second integer is the index of the last occurrence. If the target is not found, both indices will be `-1`.

### Binary Search:
Binary search is a divide-and-conquer algorithm used to find a particular element in a sorted array. The main idea is to divide the array into two halves repeatedly until the target element is found or the size of the subarray becomes zero.

### Function: `firstOccurence`:
This function finds the first occurrence of the target in the array.

1. **Initialization**:
   - `low` is initialized to `0` (start of the array).
   - `high` is initialized to `nums.length - 1` (end of the array).

2. **Binary Search Loop**:
   - The loop continues as long as `low` is less than or equal to `high`.
   - `mid` is calculated as the middle index of the current subarray.
   - If `nums[mid]` is greater than the target, it means the target lies in the left half, so `high` is updated to `mid - 1`.
   - If `nums[mid]` is less than the target, it means the target lies in the right half, so `low` is updated to `mid + 1`.
   - If `nums[mid]` is equal to the target, we check if the previous element is also the same as the target. If it is, it means the first occurrence is still to the left, so `high` is updated to `mid - 1`. If not, `mid` is the first occurrence, and it's returned.

3. **Return Value**:
   - If the loop completes without finding the target, `-1` is returned.

### Function: `lastOccurence`:
This function finds the last occurrence of the target in the array. It's very similar to `firstOccurence`, but with a few tweaks.

1. **Initialization**:
   - Same as `firstOccurence`.

2. **Binary Search Loop**:
   - The loop and `mid` calculation are the same.
   - The conditions for greater than and less than remain unchanged.
   - If `nums[mid]` is equal to the target, we check if the next element is also the same as the target. If it is, it means the last occurrence is still to the right, so `low` is updated to `mid + 1`. If not, `mid` is the last occurrence, and it's returned.

3. **Return Value**:
   - Same as `firstOccurence`.

### Intuition:
The intuition behind this approach is to leverage the sorted nature of the array. By using binary search, we can quickly narrow down the possible positions of the target. The modifications to the standard binary search (checking adjacent elements) ensure we find the first and last occurrences specifically.
 */
