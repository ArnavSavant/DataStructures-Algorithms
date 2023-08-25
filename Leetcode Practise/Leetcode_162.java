public class Leetcode_162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid - 1] >= nums[mid + 1]) {
                    high = mid - 1;
                } else if (nums[mid + 1] > nums[mid - 1]) {
                    low = mid + 1;
                }
            }
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }

            }
            if (mid == n - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    System.out.println("hello");
                    return mid - 1;
                }
            }
        }
        return -1;
    }
}

/*
### Goal:

Given an input array `nums` of size `n`, where `nums[i] != nums[i+1]` for each valid index `i`, the goal is to find the index of any peak element in the array. A peak element is defined as an element which is greater than both its neighbors. The edge cases here are the elements at the beginning and end of the array, where they have only one neighbor.

### Assumptions:
- For array inputs with size `n = 1`, the single element is considered the peak.
- `nums[-1]` is considered to be a value `-∞` (negative infinity) and `nums[n]` is also `-∞` for the purposes of identifying peaks at the start or end of the array.

### Code Explanation:

1. **Handling Edge Case**:
    ```java
    if(n==1) {
        return 0;
    }
    ```
    If the array has only one element, it is considered the peak, and its index (0) is returned.

2. **Initialization**:
    ```java
    int low = 0;
    int high = n - 1;
    ```
    Initialize pointers `low` and `high` to the start and end of the array, respectively.

3. **Binary Search**:
    ```java
    while (low <= high) {
        ...
    }
    ```
    The main logic uses a binary search approach. Here's a breakdown:

    - **Middle Element Calculation**:
        ```java
        int mid = high - (high - low) / 2;
        ```
        This line calculates the middle index of the current search space. It avoids potential integer overflow that might occur with `(low + high) / 2`.

    - **Checking Middle Element**:
        ```java
        if (mid > 0 && mid < n - 1) {
            ...
        }
        ```
        The conditions inside this block only apply when `mid` is not at the boundaries of the array.

        - If `nums[mid]` is greater than its neighbors (`nums[mid-1]` and `nums[mid+1]`), then it is a peak and its index is returned.
        - If `nums[mid-1]` is larger or equal to `nums[mid+1]`, then there might be a peak on the left side. So, we shift our search space to the left by making `high = mid - 1`.
        - If `nums[mid+1]` is greater than `nums[mid-1]`, there might be a peak on the right side. So, the search space is shifted to the right by setting `low = mid + 1`.

    - **Checking Boundary Elements**:

        - **Starting Boundary**:
            ```java
            if (mid == 0) {
                ...
            }
            ```
            If `mid` is at the start of the array, it checks if `nums[mid]` is greater than `nums[mid + 1]`. If true, then `nums[mid]` is a peak, otherwise `nums[mid + 1]` is the peak.

        - **Ending Boundary**:
            ```java
            if (mid == n - 1) {
                ...
            }
            ```
            If `mid` is at the end of the array, it checks if `nums[mid]` is greater than `nums[mid - 1]`. If true, then `nums[mid]` is a peak, otherwise `nums[mid - 1]` is the peak.

4. **Default Return**:
    ```java
    return -1;
    ```
    If the loop exits without finding a peak (this shouldn't happen given the problem constraints), it defaults to returning `-1`.

### Intuition:

The key insight is based on the nature of the peaks. When we encounter a number and its next number is bigger, then there is definitely a peak to its right. The reason being, if the numbers kept increasing, the last number would be a peak. If the numbers start to decrease at some point, the point right before they start decreasing is the peak. This is why binary search is effective, as we can keep narrowing down our potential peak's location.

Similarly, if we encounter a number and its next number is smaller, then there is definitely a peak to its left using the same logic.
 */