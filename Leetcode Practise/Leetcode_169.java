public class Leetcode_169 {
   public int majorityElement(int[] nums) {
      int count = 0;
      int element = 0;
      for (int i = 0; i < nums.length; i++) {
         if (count == 0) {
            element = nums[i];
         }
         if (element == nums[i]) {
            count++;
         } else {
            count--;
         }
      }
      return element;
   }
}

/*
 Logic
Initialization: Two variables count and element are initialized to 0. count will keep track of the occurrences of the current majority candidate, and element will store the current majority candidate.

Iterating Through the Array: The loop iterates through the array from the beginning to the end.

a. Resetting the Majority Candidate: If count is 0, the current element becomes the new majority candidate, and element is set to the current element in the array.

b. Incrementing or Decrementing the Count: If the current element is equal to the current majority candidate (element), count is incremented by 1. If the current element is different, count is decremented by 1.

Result: After the loop completes, element contains the majority element of the array.

Intuition
The intuition behind this algorithm is that if a number is indeed the majority element, it will survive the incrementing and decrementing of the count variable. Every time a different number is encountered, the count is decremented, and every time the same number (majority candidate) is encountered, the count is incremented. If the count reaches 0, a new majority candidate is chosen.

Example
Consider the array [3, 3, 4, 2, 4, 4, 2, 4, 4]. The function will return 4, which is the majority element.

Note
This code assumes that there is always a majority element in the array. If there's a possibility that the array doesn't contain a majority element, additional validation (e.g., a second pass through the array to confirm that the candidate is indeed the majority element) would be needed.

The Boyer-Moore Voting Algorithm is an efficient way to find the majority element, with a time complexity of O(n) and constant space complexity O(1).
 */
