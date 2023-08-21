public class Leetcode_540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (low <= high) {
            mid = high - (high - low) / 2;
            if (mid > 0 && mid < n - 1 && nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else if (mid == n - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {
                if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (mid % 2 == 1) {
                if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return nums[mid];
    }
}

/*
to find a single non-duplicate number in a sorted array. The array has every number appearing exactly twice, except for one number which appears only once.

### Intuition:
The problem is a classic example of a binary search application. Since the array is sorted and every number appears twice except for one, we can use the indices of the numbers to determine where the single non-duplicate number is.

### Logic:

1. **Base Case**:
   - If the array length `n` is 1, then the only number in the array is the answer.
   
2. **Binary Search**:
   - Initialize `low` to 0 and `high` to `n-1`.
   - While `low` is less than or equal to `high`:
     - Calculate the middle index `mid`.
     - Check if the number at `mid` is the non-duplicate:
       - If `nums[mid]` is not equal to its neighbors (`nums[mid-1]` and `nums[mid+1]`), then `nums[mid]` is the answer.
       - If `mid` is at the start or end of the array and doesn't match its only neighbor, then `nums[mid]` is the answer.
     - If `mid` is even:
       - If `nums[mid]` is equal to `nums[mid+1]`, then the non-duplicate number is on the right side of `mid`, so move `low` to `mid + 1`.
       - Otherwise, it's on the left side, so move `high` to `mid - 1`.
     - If `mid` is odd:
       - If `nums[mid]` is equal to `nums[mid+1]`, then the non-duplicate number is on the left side of `mid`, so move `high` to `mid - 1`.
       - Otherwise, it's on the right side, so move `low` to `mid + 1`.

3. **Return**:
   - If the loop completes without returning, then return `nums[mid]`.

### Complexity:

- **Time Complexity**: The code uses binary search, which divides the search interval in half with each iteration. Thus, the time complexity is \(O(\log n)\), where \(n\) is the length of the array.
  
- **Space Complexity**: The code uses a constant amount of space regardless of the input size, so the space complexity is \(O(1)\).

In summary, the code efficiently finds the single non-duplicate number in a sorted array using binary search. The sorted nature of the array and the fact that every number appears twice (except one) are key to the solution.
 */
