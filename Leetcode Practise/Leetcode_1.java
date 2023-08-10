import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {
   public int[] twoSum(int[] nums, int target) {
      int ans[] = new int[2];
      Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
      for(int i=0;i<nums.length;i++) {
         if(mp.containsKey(target - nums[i])) {
            ans[0] = mp.get(target - nums[i]);
            ans[1] = i;
         }
         else {
            mp.put(nums[i], i);
         }
      }
      return ans; 
   }
}

/*
 Objective
The goal is to find two indices i and j in the given array nums such that nums[i] + nums[j] = target. The function returns these indices as an array.

Approach
Initialization: An integer array ans is initialized to store the result, and a HashMap mp is created to store the numbers encountered so far along with their indices.

Iterating Through the Array: The code iterates through the array using a loop.

a. Checking for Complement: For each element nums[i], it checks if the complement (target - nums[i]) is present in the HashMap.

Found Complement: If the complement is found, the indices of the complement and the current element are stored in ans[0] and ans[1], respectively.
b. Storing Current Element: If the complement is not found, the current element nums[i] and its index i are stored in the HashMap.

Returning the Result: The function returns the ans array containing the indices of the two elements that add up to the target.

Intuition
The intuition behind this approach is to use a HashMap to efficiently keep track of the numbers encountered so far. By checking the complement of the current number, the code can quickly determine if the required pair has been found.

Example
Consider the array [2, 7, 11, 15] and target 9. The function will return [0, 1], as nums[0] + nums[1] = 9.

Note
The code assumes that there is exactly one solution, and it doesn't handle the case where no solution is found. If there's a possibility that no solution exists, additional error handling may be needed.
The time complexity of this code is O(n), and the space complexity is also O(n), where n is the length of the input array.
 */
