public class Leetcode_136 {
   public int singleNumber(int[] nums) {
      int res = 0;
      for (int i = 0; i < nums.length; i++) {
         res = res ^ nums[i];
      }
      return res;
   }
}

/*
 Logic
Initialization: The variable res is initialized to 0. It will be used to store the result.

Iterating Through the Array: The loop iterates through the entire array.

a. XOR Operation: Inside the loop, the XOR (^) operation is performed between res and the current element (nums[i]). The result is stored back in res.

Result: After the loop completes, res will contain the single number that appears only once in the array, and it is returned.

Intuition
The intuition behind this code relies on the properties of the XOR operation:

XORing a number with itself results in 0: a ^ a = 0
XORing a number with 0 results in the number itself: a ^ 0 = a
XOR is commutative and associative: a ^ b = b ^ a and (a ^ b) ^ c = a ^ (b ^ c)
Since every number in the array appears exactly twice except for one, all the duplicate numbers will cancel each other out through the XOR operation, leaving only the single number that appears once.

Example
Consider the array [4, 1, 2, 1, 2]. The function will result in 4, as 4 is the only number that appears once.

Note
This code is highly efficient, with a time complexity of O(n) and a space complexity of O(1). 
 */
