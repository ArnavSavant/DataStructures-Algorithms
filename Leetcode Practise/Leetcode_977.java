public class Leetcode_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                break;
            }
        }
        if (i == 0) {
            for (i = 0; i < n; i++) {
                ans[i] = nums[i] * nums[i];
            }
        } else {
            int j = i - 1;
            int k = 0;
            while (j >= 0 && i < n) {
                if (Math.abs(nums[j]) < nums[i]) {
                    ans[k] = nums[j] * nums[j];
                    j--;
                } else {
                    ans[k] = nums[i] * nums[i];
                    i++;
                }
                k++;
            }
            while (j >= 0) {
                ans[k] = nums[j] * nums[j];
                j--;
                k++;
            }
            while (i < n) {
                ans[k] = nums[i] * nums[i];
                i++;
                k++;
            }
        }
        return ans;
    }
}
/*
The `sortedSquares` method efficiently calculates the squares of all elements in a sorted array `nums` (which may contain both negative and positive numbers), and returns a new array with the squares sorted in non-decreasing order. The approach takes advantage of the input array's sorted property to optimize the process.

### Algorithm

1. **Initialization**: Create an array `ans` to store the squared values. Find the first non-negative number's index in `nums` by iterating through it. This index (`i`) effectively splits the array into negative and non-negative parts.

2. **Handle All Non-negative Case**: If `i` is `0`, meaning all elements are non-negative, square each element directly as the array is already sorted.

3. **Two-pointer Technique for Mixed Arrays**:
   - Use two pointers: `j` for the last negative number (initially `i-1`) and `i` for the first non-negative number.
   - Compare the absolute values of elements pointed by `i` and `j`. Square the smaller one and move the respective pointer (`i` forward or `j` backward), filling the `ans` array from the start.
   - Continue until all elements from both parts of the array are processed.

4. **Post-processing**:
   - If any negative numbers are left (when `j >= 0`), square them in reverse order to ensure sorting.
   - If any non-negative numbers are left (when `i < n`), square them in their original order.

### Time and Space Complexity

- **Time Complexity**: O(n), where `n` is the length of the input array `nums`. Each element is processed exactly once, either in finding the first non-negative number or in merging the squared values.

- **Space Complexity**: O(n) for the output array `ans`. No additional space is used beyond variables for iteration and indices.

### Summary

The `sortedSquares` method demonstrates an efficient way to work with sorted arrays, leveraging the sorted property to minimize computational overhead. By applying a two-pointer technique, it manages to avoid the need for sorting after squaring the elements, ensuring optimal performance.
 */