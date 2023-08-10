public class Leetcode_189 {
   public void rotate(int[] nums, int k) {
      k = k % nums.length;
      reverse(nums, 0, nums.length-k-1);
      reverse(nums, nums.length-k, nums.length - 1);
      reverse(nums, 0, nums.length - 1);
   }

   public void reverse(int arr[], int low, int high) {
      while (low < high) {
         swap(arr, low, high);
         low++;
         high--;
      }
   }

   public void swap(int arr[], int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
}

/*
The code you've shared is a classic way to rotate an array to the right by k places. Let's break down how it works, step by step:

Modulo Operation: First, the code takes the modulo of k with the length of the array. This ensures that if 
k is greater than the length of the array, it wraps around. Essentially, it finds the effective number of rotations needed.

First Reverse: The code then reverses the first part of the array, from index 0 to nums.length−k−1. This reverses the elements that will eventually end up at the end of the rotated array.

Second Reverse: Next, the code reverses the second part of the array, from index nums.length−k to nums.length−1. This reverses the elements that will eventually end up at the beginning of the rotated array.

Third Reverse: Finally, the code reverses the entire array. This puts the previously reversed sections into their correct positions, completing the rotation.

Here's a visual example to help you understand:

Original array: [1, 2, 3, 4, 5, 6]
k=2
After first reverse (first 4 elements): [4, 3, 2, 1, 5, 6]
After second reverse (last 2 elements): [4, 3, 2, 1, 6, 5]
After third reverse (entire array): [5, 6, 1, 2, 3, 4]
The array has been rotated to the right by 2 places!

This approach is efficient because it performs the rotation in-place, without needing additional memory, and it does so in O(n) time complexity. 
 */
