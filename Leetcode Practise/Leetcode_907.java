import java.util.Stack;

public class Leetcode_907 {
    public int sumSubarrayMins(int[] arr) {
        int nextMinLeft[] = nextSmallestToLeft(arr);
        int nextMinRight[] = nextSmallestToRight(arr);
        long mod = 1000000007;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + ((((nextMinLeft[i] % mod) * (nextMinRight[i] % mod)) % mod) * arr[i]) % mod) % mod;
        }
        return (int) ans;
    }

    public int[] nextSmallestToLeft(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = i - (-1);
            } else {
                ans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] nextSmallestToRight(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = arr.length - i;
            } else {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}

/*
This code is trying to solve a problem related to finding the sum of all possible minimums of subarrays from the input array `arr`. Specifically, for each element in `arr`, it considers all subarrays that include that element, and for each such subarray, it adds the minimum value of that subarray to a total sum. The final answer is this total sum modulo 1,000,000,007.

### Explanation

Let's break it down step by step:

1. **Find Next Smaller Element Distances**
   - **`nextSmallestToLeft(int[] arr)`**: Finds the distance from each element to the next smaller element to its left. It uses a stack to keep track of indices of the elements. The resulting array `nextMinLeft` will contain for each index `i`, the number of elements between `arr[i]` and the next smaller element to its left (not including `arr[i]`).
   - **`nextSmallestToRight(int[] arr)`**: Similar to `nextSmallestToLeft`, but finds the distance to the next smaller element to the right of each element. The resulting array `nextMinRight` will contain for each index `i`, the number of elements between `arr[i]` and the next smaller element to its right (not including `arr[i]`).
  
2. **Calculating the Sum of Minimums of All Subarrays**
   - With `nextMinLeft` and `nextMinRight`, for each element `arr[i]`, you know how many subarrays have `arr[i]` as the minimum (given by the product of corresponding values in `nextMinLeft` and `nextMinRight`).
   - Then, in the main function `sumSubarrayMins(int[] arr)`, the code calculates the sum of all subarray minimums by iterating through each element in `arr` and adding to the sum the product of the number of subarrays (for which it is a minimum) and the element value, modulo 1,000,000,007.

### Why does it work?

For each element `arr[i]`, `nextMinLeft[i]` tells us how many elements to the left (including itself) it is the minimum element for, and similarly, `nextMinRight[i]` tells us the count to the right. By multiplying these two values, we find how many subarrays have `arr[i]` as their minimum element because for a subarray to have `arr[i]` as minimum, it should not contain any smaller elements than `arr[i]` on both left and right sides. Therefore, each subarray is uniquely determined by two indices: one in the range `[i - nextMinLeft[i] + 1, i]` and one in the range `[i, i + nextMinRight[i] - 1]`.

### Time Complexity Analysis

- **O(n)** for each of the `nextSmallestToLeft` and `nextSmallestToRight` functions since they use a stack and each element is pushed and popped from the stack exactly once.
- **O(n)** for the loop in the `sumSubarrayMins` function, as it just iterates through each element once.
- So, the overall time complexity is **O(n)**.

### Space Complexity Analysis

- **O(n)** for the `nextMinLeft` and `nextMinRight` arrays.
- **O(n)** for the stack used in the `nextSmallestToLeft` and `nextSmallestToRight` methods.
- Therefore, the space complexity is also **O(n)**.

### Conclusion

The algorithm cleverly reduces a seemingly complex problem into a linear-time solution by utilizing the stack data structure to keep track of the relevant indices, and precomputing the number of subarrays where each element is the minimum, and thus achieving a time and space-efficient solution.
 */