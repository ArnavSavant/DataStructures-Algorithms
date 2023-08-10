public class Leetcode_75 {
   public void sortColors(int[] nums) {
      int low = 0;
      int high = nums.length - 1;
      int mid = 0;
      while(mid <= high) {
         if(nums[mid] == 0) {
            nums[mid] = nums[low];
            nums[low] = 0;
            low++;
            mid++;
         }
         else if(nums[mid] == 1) {
            mid++;
         }
         else {
            nums[mid] = nums[high];
            nums[high] = 2;
            high--;
         }
      }
   }
}

/*
 Variables:
low: Points to the next position where a 0 should be placed.
mid: Points to the current element being considered.
high: Points to the next position where a 2 should be placed.

Logic:
Initialize Pointers: low and mid are initialized to 0, and high is initialized to the last index of the array.
Iterate Through the Array: The loop continues as long as mid is less than or equal to high.
a. If Element is 0: Swap the elements at mid and low, then increment both low and mid. This ensures that all 0s are placed at the beginning.
b. If Element is 1: Simply increment mid, as 1s are already in their correct position.
c. If Element is 2: Swap the elements at mid and high, then decrement high. This ensures that all 2s are placed at the end.
Result: The array is sorted with all 0s first, followed by all 1s, and then all 2s.

Intuition:
The intuition behind this code is to use three pointers to segregate the three different elements. By keeping track of the next positions where 0s and 2s should be placed (low and high), and iterating through the array with mid, the code efficiently sorts the elements.

Example:
Consider the array [2, 0, 1, 2, 1]. The function will result in [0, 1, 1, 2, 2].

Note:
This algorithm is efficient with a time complexity of O(n) and doesn't require any additional space. 
 */