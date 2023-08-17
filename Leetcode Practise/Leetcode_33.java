public class Leetcode_33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

/*
### Overview:
The code is an implementation of a modified binary search to handle the case where a sorted array has been rotated. For example, the array `[4,5,6,7,0,1,2]` is a rotation of the sorted array `[0,1,2,4,5,6,7]`.

### Detailed Explanation:

1. **Initialization**:
   ```java
   int low = 0;
   int high = nums.length - 1;
   ```
   - We start by defining two pointers, `low` and `high`, which represent the start and end of the current search interval.

2. **Binary Search Loop**:
   ```java
   while (low <= high) {
   ```
   - The loop continues as long as the `low` pointer is less than or equal to the `high` pointer.

3. **Calculate Midpoint**:
   ```java
   int mid = high - (high - low) / 2;
   ```
   - This calculates the midpoint of the current search interval. It's a safer way to compute the midpoint than `(low + high) / 2`, which can cause integer overflow.

4. **Check for Target**:
   ```java
   if(nums[mid] == target) {
       return mid;
   }
   ```
   - If the element at the midpoint is the target, we've found our value and return the index.

5. **Determine Rotation Point**:
   The array is split into two halves by the rotation: one half is sorted, and the other contains the rotation point. We need to determine which half the midpoint is in.

   ```java
   if (nums[mid] >= nums[low]) {
   ```
   - If the element at `mid` is greater than or equal to the element at `low`, then the left half (from `low` to `mid`) is sorted.

6. **Search in the Left Sorted Half**:
   ```java
   if (target >= nums[low] && target <= nums[mid]) {
       high = mid - 1;
   } else {
       low = mid + 1;
   }
   ```
   - If the target lies within the sorted left half, we adjust the `high` pointer to search only in this half. Otherwise, we adjust the `low` pointer to search in the right half.

7. **Search in the Right Sorted Half**:
   ```java
   else if (nums[mid] <= nums[high]) {
       if (target >= nums[mid] && target <= nums[high]) {
           low = mid + 1;
       } else {
           high = mid - 1;
       }
   }
   ```
   - Similarly, if the right half (from `mid` to `high`) is sorted and the target lies within this half, we adjust the `low` pointer. Otherwise, we adjust the `high` pointer.

8. **Return -1 if Not Found**:
   ```java
   return -1;
   ```
   - If the loop completes without finding the target, we return `-1` to indicate the target is not in the array.

### Intuition:
The key intuition here is leveraging the properties of the sorted rotated array. At any given midpoint, one half of the array (either left or right) will always be sorted. By identifying which half is sorted, we can easily determine if the target lies within that half or the other half, allowing us to effectively halve our search space with each iteration, just like in a standard binary search.
 */
