public class Solution_283 {
   public void moveZeroes(int nums[]) {
      if (nums.length == 1) {
         return;
      }
      int j = 0 ;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != 0) {

            // Swap the current non-zero element with the element at position j
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

            // Increment the pointer to the last non-zero element
            j++;
         }
      }
   }
}

/*
 Function: moveZeroes
The function moveZeroes takes an integer array nums and moves all the zeroes to the end of the array while maintaining the relative order of the non-zero elements.

Logic and Intuition
Early Exit for Single Element: If the array has only one element, there's no need to move anything, so the function returns immediately.

Initialization of Pointer j: A pointer j is initialized to 0. This pointer will keep track of the position where the next non-zero element should be placed.

Iterating Through the Array: The loop iterates through the array from the beginning.
a. Non-Zero Element Found: If a non-zero element is found at position i, it is swapped with the element at position j.
b. Incrementing j: After the swap, j is incremented to point to the next position where a non-zero element should be placed.
c. Zero Element Found: If a zero element is found, the loop continues to the next iteration without any changes.

Result: After the loop completes, all zeroes are moved to the end of the array, and the relative order of non-zero elements is maintained.

Intuition
The intuition behind this code is to use two pointers: one (i) to iterate through the array and the other (j) to keep track of the position where the next non-zero element should be placed. By swapping non-zero elements with the elements at position j, all zeroes naturally end up at the end of the array.

Example
Consider the array [0, 2, 0, 3, 4]. The function will result in [2, 3, 4, 0, 0].

Efficiency
This optimized code has a linear time complexity of O(n) and doesn't require any additional space, making it an efficient solution for the problem.

 */
