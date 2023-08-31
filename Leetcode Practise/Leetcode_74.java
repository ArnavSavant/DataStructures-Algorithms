public class Leetcode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m - 1;
        int mid = 0;
        while (low <= high) {
            mid = high - (high - low) / 2;
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target > matrix[mid][n - 1]) {
                low = mid + 1;
            } else {
                break;
            }
        }
        low = 0;
        high = n - 1;
        int x = mid;
        while (low <= high) {
            mid = high - (high - low) / 2;
            if (target == matrix[x][mid]) {
                return true;
            } else if (target > matrix[x][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}

/*
Certainly! This `searchMatrix` function is designed to search for a `target` value in a 2D matrix. The matrix must adhere to two conditions for this code to work:

1. Integers in each row are sorted from left to right.
2. The first integer of each row is greater than the last integer of the previous row.

Given these properties, the algorithm adopts a two-step binary search.

**Step 1: Determine the row.**

The first while loop conducts a binary search on the matrix's rows. For each "middle" row:

- If the `target` is smaller than the first element of the row, then the target must be in a previous row.
- If the `target` is larger than the last element of the row, then the target must be in a subsequent row.
- If neither of the above holds, then the target must be in the current row, and we break out of the loop.

By the end of this loop, if the target is in the matrix, we know the row in which it resides. This row is denoted by the index `mid` (let's call this row_mid).

**Step 2: Search within the determined row.**

The second while loop is a standard binary search within the row `row_mid` (found in step 1). For each "middle" element in the row:

- If the target matches the element, we found the target and return `true`.
- If the target is greater, it lies to the right and we adjust our `low`.
- If the target is smaller, it lies to the left and we adjust our `high`.

If we finish the second loop without returning, then the `target` isn't in the determined row and, by extension, isn't in the matrix. Thus, we return `false`.

**Intuition**

Think of the entire matrix as a 1D sorted list (given the matrix's properties). If we had to find an element in a 1D sorted list, we'd use binary search. Since this is a 2D matrix with a specific structure, we can conduct a binary search in 2 steps: first, to determine the row, and second, to pinpoint the exact location within the row.

**Note**: The way `mid` is calculated `mid = high - (high - low) / 2` is essentially equivalent to the more common `mid = low + (high - low) / 2`. Both will correctly calculate the midpoint without causing overflow issues as `mid = (low + high) / 2` might in some programming languages for large indices.
 */