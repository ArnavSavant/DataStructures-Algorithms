import java.util.HashMap;
import java.util.Map;

public class NumberofSubarraysWithKDistinctIntegers {
    public static int kDistinctSubarrays(int[] arr, int n, int k) {
        return atmost(arr, n, k) - atmost(arr, n, k - 1);
    }

    public static int atmost(int arr[], int n, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            if (mp.containsKey(arr[j])) {
                mp.put(arr[j], mp.get(arr[j]) + 1);
            } else {
                mp.put(arr[j], 1);
            }
            while (i <= j && mp.size() > k) {
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if (mp.get(arr[i]) == 0) {
                    mp.remove(arr[i]);
                }
                i++;
            }
            count = count + (j - i + 1);
            j++;
        }
        return count;
    }
}
/*
The provided code is a Java function that calculates the number of subarrays with exactly `k` distinct elements in a given array. It leverages the technique of first finding the number of subarrays with at most `k` distinct elements and then subtracting from it the number of subarrays with at most `k-1` distinct elements to get the exact count of subarrays with `k` distinct elements.

### Detailed Logic and Intuition:

The code consists of two functions:

1. `kDistinctSubarrays`: This is the main function that leverages the helper function `atmost`. It calculates the number of subarrays with at most `k` distinct elements and subtracts from it the number of subarrays with at most `k-1` distinct elements.

2. `atmost`: This helper function calculates the number of subarrays that have at most `k` distinct elements.

#### `atmost` Function Breakdown:

- **HashMap (`mp`)**: It keeps track of the frequency of each element in the current subarray.
  
- **Two Pointers (`i` and `j`)**: These pointers represent the left and right bounds of the sliding window (subarray) currently being considered. The variable `i` is the start index, and `j` is the end index.

- **Sliding Window Technique**:
  - The outer `while` loop moves `j` from the beginning to the end of the array, expanding the window to include `arr[j]`.
  - If `arr[j]` is already in the map, its count is incremented. If it is not, it is added to the map with a count of 1.
  - The inner `while` loop checks if the map size (which represents the number of distinct elements in the current window) exceeds `k`. If it does, the loop shrinks the window from the left by incrementing `i`, decreasing the count of `arr[i]` in the map, and if the count drops to zero, removing `arr[i]` from the map.

- **Counting Subarrays**: For each position of `j`, the number of subarrays with at most `k` distinct elements ending at `j` is `j - i + 1`. This is because you can form subarrays starting from any index `i` to `j` that would have at most `k` distinct elements. The count is accumulated in the variable `count`.

### Why It Works:

This algorithm works on the principle of inclusion-exclusion. By finding the number of subarrays with at most `k` distinct elements and subtracting the number of subarrays with at most `k-1` distinct elements, we eliminate those subarrays that have fewer than `k` distinct elements, thus obtaining the count of subarrays with exactly `k` distinct elements.

### Complexity Analysis:

- **Time Complexity**:
  - The `atmost` function has a time complexity of \( O(n) \), as both `i` and `j` traverse the array at most once each.
  - The `kDistinctSubarrays` function calls `atmost` twice, so the overall time complexity is still \( O(n) \) because the two calls do not nest and are executed sequentially.

- **Space Complexity**:
  - The space complexity is \( O(k) \) for the `atmost` function since the map can store at most `k` distinct elements when the window has exactly `k` distinct elements. If the number of distinct elements in the array is less than `k`, then the space complexity would be \( O(u) \) where `u` is the number of unique elements in `arr`.

This code is optimized for the problem it addresses. The sliding window technique is a standard and efficient approach for array interval problems, especially those that involve contiguous subarray computations.
 */