public class Leetcode_485 {
   public int findMaxConsecutiveOnes(int[] nums) {
      int max = 0;
      int count = 0;

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == 1) {
            count++;
         } else {
            max = Math.max(max, count);
            count = 0;
         }
      }
      max = Math.max(max, count);
      return max;
   }
}

/*
 Logic
Initialization: Two variables, max and count, are initialized to 0. max will keep track of the maximum number of consecutive ones found so far, and count will keep track of the current streak of consecutive ones.

Iterating Through the Array: The loop iterates through the entire array, checking each element.
a. One Found: If the current element is 1, count is incremented, continuing the streak of consecutive ones.
b. Zero Found: If the current element is 0, the streak of consecutive ones is broken. The code then compares the current count with max, updating max if count is greater. count is then reset to 0 to start a new streak.

Final Check: After the loop, there's one more check to compare max with count. This ensures that if the array ends with a streak of ones, it's considered in the final result.

Result: The function returns max, which contains the length of the longest streak of consecutive ones in the array.

Intuition
The intuition behind this code is to keep track of two variables: the current streak of consecutive ones (count) and the maximum streak found so far (max). By iterating through the array and updating these variables based on the current element, the code efficiently finds the longest streak of consecutive ones.

Example
Consider the array [1, 1, 0, 1, 1, 1]. The function will result in 3, as the longest streak of consecutive ones is of length 3.

Time Complexity
The time complexity of this code is O(n), where n is the length of the array, as it iterates through the array once.


 */
