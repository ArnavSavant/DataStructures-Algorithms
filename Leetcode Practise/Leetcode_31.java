public class Leetcode_31 {
   public void nextPermutation(int[] nums) {
      int n = nums.length;
      int k = -1;
      for (int i = n - 2; i >= 0; i--) {
         if (nums[i] < nums[i + 1]) {
            k = i;
            break;
         }
      }

      if (k == -1) {
         reverse(nums, 0, n - 1);
         return;
      }

      for (int i = n - 1; i >= k; i--) {
         if (nums[i] > nums[k]) {
            swap(nums, k, i);
            break;
         }
      }
      reverse(nums, k + 1, n - 1);
   }

   public void swap(int arr[], int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public void reverse(int arr[], int low, int high) {
      int start = low;
      int end = high;
      while (start <= end) {
         swap(arr, start, end);
         start++;
         end--;
      }
   }
}

/*
 * to find the next lexicographically greater permutation of a given sequence of
 * numbers. If no such permutation exists, it rearranges the numbers to the
 * smallest possible order (i.e., sorted in ascending order). Let's break down
 * the logic and intuition of the code:
 * 
 * Finding the First Decreasing Element from Right:
 * 
 * Starting from the rightmost element, the code looks for the first pair of
 * adjacent elements (nums[i], nums[i + 1]) where nums[i] < nums[i + 1].
 * The index i is stored in variable k.
 * If no such pair is found, it means the sequence is already in descending
 * order, and there's no next permutation. In this case, the array is reversed
 * to get the smallest permutation.
 * Finding the Element to Swap:
 * 
 * If k is found, the code looks for the smallest element greater than nums[k]
 * from the right of k.
 * The index of this element is then swapped with k.
 * Reversing the Subarray:
 * 
 * After the swap, the subarray to the right of k is still in descending order.
 * To get the smallest lexicographically greater permutation, this subarray is
 * reversed.
 * Why This Code Works:
 * Lexicographical Order: The code ensures that the next permutation is the
 * smallest one that's greater than the current permutation by carefully
 * choosing the elements to swap and reverse.
 * Handling Edge Cases: If the array is already in descending order, the code
 * correctly identifies that there's no next permutation and returns the
 * smallest permutation.
 * Efficiency: The code uses constant space and linear time, making it
 * efficient.
 * Detailed Explanation:
 * Finding k: By finding the first decreasing element from the right, you
 * identify the "violation" of the increasing order. This is the point where you
 * can make a change to get a greater permutation.
 * 
 * Swapping with a Greater Element: By swapping nums[k] with a number just
 * greater than it, you ensure that the permutation is greater but still as
 * close as possible to the current permutation.
 * 
 * Reversing the Subarray: Since the subarray to the right of k is in descending
 * order, reversing it will sort it in ascending order. This ensures that the
 * permutation is the smallest possible one that's greater than the current
 * permutation.
 * 
 * The combination of these steps guarantees that the code finds the next
 * permutation in lexicographical order or returns the smallest permutation if
 * no next permutation exists.
 */
