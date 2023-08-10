public class Leetcode_268 {
   public int missingNumber(int[] nums) {
      int n = nums.length;
      int sum1 = (n * (n + 1)) / 2;
      int sum2 = 0;
      for (int i = 0; i < n; i++) {
         sum2 = sum2 + nums[i];
      }
      return sum1 - sum2;
   }
}

/*
 *Logic
Calculate Expected Sum: The variable sum1 calculates the sum of the first n natural numbers using the formula (n * (n + 1)) / 2. Since the array contains n unique integers from 0 to n, the sum of all numbers including the missing one would be this value.

Calculate Actual Sum: The variable sum2 calculates the actual sum of the numbers in the array by iterating through it.

Find Missing Number: The missing number is found by subtracting the actual sum (sum2) from the expected sum (sum1).

Intuition
The intuition behind this code is to leverage the arithmetic progression sum formula to find the expected sum of the first n natural numbers. By comparing this with the actual sum of the numbers in the array, we can easily find the missing number.

Example
Consider the array [3, 0, 1]. The length n is 3, so the expected sum of numbers from 0 to 3 is (3 * (3 + 1)) / 2 = 6. The actual sum of the numbers in the array is 3 + 0 + 1 = 4. The missing number is 6 - 4 = 2, so the function returns 2.

Efficiency
This code has a time complexity of O(n) and a space complexity of O(1), making it an efficient solution to the problem.

Note
The code assumes that there is exactly one missing number in the range from 0 to n, and that the other numbers are unique. If these assumptions are not met, the code may not work as intended.
 */