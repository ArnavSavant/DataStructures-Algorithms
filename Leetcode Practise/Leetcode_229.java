import java.util.ArrayList;
import java.util.List;

public class Leetcode_229 {
   public List<Integer> majorityElement(int[] nums) {
      List<Integer> answer = new ArrayList<Integer>();
      int n = nums.length;
      int count1 = 0;
      int count2 = 0;
      int element1 = Integer.MIN_VALUE;
      int element2 = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
         if (count1 == 0 && element2 != nums[i]) {
            count1 = 1;
            element1 = nums[i];
         } else if (count2 == 0 && element1 != nums[i]) {
            count2 = 1;
            element2 = nums[i];
         } else if (element1 == nums[i]) {
            count1++;
         } else if (element2 == nums[i]) {
            count2++;
         } else {
            count1--;
            count2--;
         }
      }
      count1 = 0;
      count2 = 0;
      for (int i = 0; i < n; i++) {
         if (element1 == nums[i]) {
            count1++;
         }
         if (element2 == nums[i]) {
            count2++;
         }
      }
      int min = (int) (n / 3) + 1;
      if (count1 >= min) {
         answer.add(element1);
      }
      if (count2 >= min) {
         answer.add(element2);
      }
      return answer;
   }
}

/*

### 1. Problem Understanding:
The problem is to find all the elements in an array that appear more than n/3 times. Since an element must appear more than n/3 times to be a majority element, there can be at most two such elements.

### 2. Initialization:
The code initializes two elements (`element1` and `element2`) and their corresponding counts (`count1` and `count2`) to keep track of the potential majority elements.

### 3. First Pass - Finding Candidates:
The code iterates through the array and uses the Boyer-Moore Voting Algorithm to find two candidates that might be the majority elements.
- If `count1` is 0 and the current number is not equal to `element2`, then the current number becomes `element1`, and `count1` is set to 1.
- If `count2` is 0 and the current number is not equal to `element1`, then the current number becomes `element2`, and `count2` is set to 1.
- If the current number is equal to `element1`, then `count1` is incremented.
- If the current number is equal to `element2`, then `count2` is incremented.
- If the current number is not equal to either `element1` or `element2`, then both `count1` and `count2` are decremented.

### 4. Second Pass - Verifying Candidates:
After the first pass, `element1` and `element2` are the candidates, but we need to verify if they are indeed majority elements.
- The code iterates through the array again and counts the occurrences of `element1` and `element2`.
- If the count of either element is greater than or equal to (n/3) + 1, then that element is added to the answer list.

### 5. Return the Result:
The code returns the list of majority elements.

### Why This Code Works:
- The Boyer-Moore Voting Algorithm ensures that if there are majority elements, they will be found as candidates.
- The second pass verifies that the candidates are indeed majority elements.
- The code efficiently handles the case where there might be one, two, or no majority elements.

The time complexity of this code is O(n), and the space complexity is O(1), making it an efficient solution to the problem.
 */