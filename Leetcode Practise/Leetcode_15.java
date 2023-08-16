import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_15 {
   public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> answer = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      int n = nums.length;
      for (int i = 0; i < n - 1; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
         }
         int j = i + 1;
         int k = n - 1;
         while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
               List<Integer> list = new ArrayList<Integer>();
               list.add(nums[i]);
               list.add(nums[j]);
               list.add(nums[k]);
               answer.add(list);
               j++;
               k--;
               while (j < k && nums[j] == nums[j - 1]) {
                  j++;
               }
               while (j < k && nums[k] == nums[k + 1]) {
                  k--;
               }
            } else if (nums[i] + nums[j] + nums[k] > 0) {
               k--;
            } else if (nums[i] + nums[j] + nums[k] < 0) {
               j++;
            }
         }
      }
      return answer;
   }
}

/*
**1. Problem Statement:**
Given an array `nums` of n integers, are there elements a, b, c in `nums` such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

**2. Intuition:**
The idea is to sort the array and then fix one element and search for other two elements using two pointers.

**3. Detailed Explanation:**

- **Initialization:**
  ```java
  List<List<Integer>> answer = new ArrayList<List<Integer>>();
  Arrays.sort(nums);
  int n = nums.length;
  ```
  Here, we initialize the `answer` list to store the results. We then sort the `nums` array. Sorting is crucial for the two-pointer technique and to avoid duplicates.

- **Iterating through the array:**
  ```java
  for (int i = 0; i < n - 1; i++) {
  ```
  We iterate through the array, fixing one number at a time.

- **Avoiding duplicates:**
  ```java
  if (i > 0 && nums[i] == nums[i - 1]) {
      continue;
  }
  ```
  If the current number is the same as the previous number, we skip it to avoid duplicate triplets.

- **Two-pointer technique:**
  ```java
  int j = i + 1;
  int k = n - 1;
  while (j < k) {
  ```
  We use two pointers, `j` and `k`, starting right after `i` and at the end of the array, respectively.

- **Checking the sum:**
  ```java
  if (nums[i] + nums[j] + nums[k] == 0) {
  ```
  We check if the sum of the numbers at positions `i`, `j`, and `k` is zero.

- **Storing the result and avoiding duplicates:**
  If the sum is zero, we store the triplet and move both pointers inward. We also have additional while loops to skip over any duplicate numbers to avoid duplicate triplets.
  
- **Moving the pointers:**
  If the sum is greater than zero, we move the `k` pointer to the left to get a smaller sum. If the sum is less than zero, we move the `j` pointer to the right to get a larger sum.

**4. Why does this code work?**
The code works because:
- Sorting the array helps in avoiding duplicates and makes the two-pointer technique possible.
- The two-pointer technique efficiently searches for two numbers in O(n) time.
- By fixing one number and using the two-pointer technique for the other two, we can find all unique triplets in O(n^2) time.

In essence, the waves of this code flow smoothly from sorting the array, fixing one number, and then using the two-pointer technique to find the other two numbers.
 */
