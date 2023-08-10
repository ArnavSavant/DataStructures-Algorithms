public class Leetcode_53 {
   public int maxSubArray(int[] nums) {
      int currSum = 0;
      int maxSum = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
         currSum = currSum + nums[i];
         if (currSum > maxSum) {
            maxSum = currSum;
         }
         if (currSum < 0) {
            currSum = 0;
         }
      }
      return maxSum;
   }
}

/*
 Logic
Initialization: Two variables are initialized, currSum to 0, and maxSum to the minimum possible integer value. currSum keeps track of the current contiguous sum, and maxSum stores the maximum contiguous sum found so far.

Iterating Through the Array: The loop iterates through the entire array, performing the following steps:
a. Add Current Element: The current element nums[i] is added to currSum.
b. Update Maximum Sum: If currSum is greater than maxSum, then maxSum is updated to the value of currSum.
c. Reset Current Sum: If currSum becomes negative, it is reset to 0. This is based on the intuition that a negative sum will not contribute positively to future sums.

Result: The value of maxSum after the loop ends is the maximum sum of any contiguous subarray within the given array.

Intuition
The intuition behind this algorithm is that any subarray sum that becomes negative will not contribute to increasing the sum of a future subarray. Therefore, whenever the current sum becomes negative, it is reset to zero, and the algorithm continues to look for the next positive contiguous sum.

Example
Consider the array [-2, 1, -3, 4, -1, 2, 1, -5, 4]. The function will return 6, corresponding to the contiguous subarray [4, -1, 2, 1].

Time Complexity
The time complexity of this algorithm is O(n), where n is the length of the array, as it iterates through the array once.

Summary
This code efficiently finds the maximum sum of a contiguous subarray within a given array using Kadane's algorithm.
 */
