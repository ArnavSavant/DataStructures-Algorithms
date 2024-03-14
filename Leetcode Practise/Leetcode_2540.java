public class Leetcode_2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
/*
The `getCommon` method finds the first common element between two sorted arrays, `nums1` and `nums2`. If there is no common element, it returns `-1`. The method uses a two-pointer technique to efficiently search for a common element without needing extra space or exhaustive comparisons.

### How It Works

1. **Initialization**: Two pointers, `i` and `j`, are initialized to start at the beginning of `nums1` and `nums2`, respectively.

2. **Comparison Loop**:
   - The loop continues as long as both pointers are within the bounds of their respective arrays.
   - If the elements pointed to by `i` and `j` are equal, that element is immediately returned as the first common element.
   - If the element in `nums1` at pointer `i` is less than the element in `nums2` at pointer `j`, the pointer `i` is incremented to move forward in `nums1`.
   - If the element in `nums1` at pointer `i` is greater than the element in `nums2` at pointer `j`, the pointer `j` is incremented to move forward in `nums2`.

3. **No Common Element Found**:
   - If the loop terminates without finding a common element (meaning one or both pointers have reached the end of their arrays without a match), the method returns `-1`.

### Time and Space Complexity

- **Time Complexity**: O(n + m), where `n` is the length of `nums1` and `m` is the length of `nums2`. In the worst case, the method may need to traverse the entirety of both arrays, but each array is only traversed once.

- **Space Complexity**: O(1), as the method only uses a constant amount of extra space regardless of the input size. The two pointers, `i` and `j`, and the return value do not scale with the size of the input arrays.

### Summary

The `getCommon` method provides a straightforward and efficient solution to finding the first common element between two sorted arrays. By leveraging the sorted nature of the arrays and using a two-pointer technique, it minimizes the number of comparisons needed to find a common element or determine that no such element exists.
 */