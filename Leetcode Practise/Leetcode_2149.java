public class Leetcode_2149 {
   public int[] rearrangeArray(int[] nums) {
      int n = nums.length;
      int ans[] = new int[n];
      int positiveIndex = 0;
      int negativeIndex = 1;
      for (int i = 0; i < n; i++) {
         if (nums[i] > 0) {
            ans[positiveIndex] = nums[i];
            positiveIndex = positiveIndex + 2;
         }
         if (nums[i] < 0) {
            ans[negativeIndex] = nums[i];
            negativeIndex = negativeIndex + 2;
         }
      }
      return ans;
   }
}

/*
 
Sure thing, friend! Let's dive deeper into the logic of the code. 🏄

Initialization:

n: Stores the length of the input array nums.
ans: An array of the same length as nums, initialized with zeros, to store the rearranged numbers.
positiveIndex: Initialized to 0, used to track the next even index where a positive number should be placed.
negativeIndex: Initialized to 1, used to track the next odd index where a negative number should be placed.
Iterating Through the Input Array:

The for loop iterates through the input array nums from index 0 to n-1.
Inside the loop, two conditions are checked for each number:
a. If Positive: If the number is greater than 0, it's placed at the current positiveIndex in the ans array. Then, positiveIndex is incremented by 2 to point to the next even index.
b. If Negative: If the number is less than 0, it's placed at the current negativeIndex in the ans array. Then, negativeIndex is incremented by 2 to point to the next odd index.
Handling of Positive and Negative Numbers:

Positive numbers are placed at even indices (0, 2, 4, ...), ensuring they are separated from negative numbers.
Negative numbers are placed at odd indices (1, 3, 5, ...), ensuring they are separated from positive numbers.
Return Result: The rearranged array ans is returned, containing positive numbers at even indices and negative numbers at odd indices.

Potential Issues:
If there are more positive numbers than available even indices or more negative numbers than available odd indices, the code will not handle the overflow, leading to incorrect results.
Zeros in the input array are not handled and will remain as zeros in the ans array.
This code snippet aims to rearrange the input array by separating positive and negative numbers, placing them at alternating positions. The logic leverages the use of two separate indices to track the placement of positive and negative numbers, ensuring they are placed at the correct positions in the result array.
 */