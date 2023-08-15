import java.util.HashMap;
import java.util.Map;

public class Leetcode_560 {
   public int subarraySum(int[] nums, int k) {
      int count = 0;
      int sum = 0;
      Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
      mp.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
         sum = sum + nums[i];
         if (mp.containsKey(sum - k)) {
            count = count + mp.get(sum - k);
         }
         if (mp.containsKey(sum)) {
            mp.put(sum, mp.get(sum) + 1);
         } else {
            mp.put(sum, 1);
         }
      }
      return count;
   }
}

/*
### Intuition:
The problem is to find the number of subarrays that have a sum equal to `k`. A brute-force approach would be to calculate the sum of all possible subarrays and check if they equal `k`. However, this code uses a more efficient approach by utilizing a HashMap to keep track of the sum of elements up to the current index and how many times this sum has occurred.

### Logic:
1. **Initialization**: `count` is initialized to 0 to keep track of the number of subarrays that sum to `k`. `sum` is initialized to 0 to keep track of the cumulative sum of the array elements. A HashMap `mp` is used to store the cumulative sum and the number of times that sum has occurred. Initially, it's populated with `(0, 1)` since the sum of an empty subarray is 0.

2. **Iterate through the array**: The code iterates through the array using a for loop.
   - **Calculate Cumulative Sum**: For each element `nums[i]`, it adds the value to the cumulative sum (`sum = sum + nums[i]`).
   - **Check for Subarray Sum**: If the HashMap contains a key `(sum - k)`, it means there is a subarray ending at the current index whose sum is `k`. The value associated with the key `(sum - k)` is added to `count`.
   - **Update HashMap**: The code then updates the HashMap with the current cumulative sum. If the sum already exists in the HashMap, it increments the value by 1. If not, it adds the sum with a value of 1.

3. **Return Result**: Finally, the code returns the `count`, which represents the total number of continuous subarrays whose sum equals `k`.

### Example:
Consider an array `nums = [1, 1, 1]` and `k = 2`. The code will work as follows:
- Iteration 1: `sum = 1`, `count = 0`, `mp = {0: 1, 1: 1}`
- Iteration 2: `sum = 2`, `count = 1` (since `mp` contains key `2 - k = 0`), `mp = {0: 1, 1: 1, 2: 1}`
- Iteration 3: `sum = 3`, `count = 2` (since `mp` contains key `3 - k = 1`), `mp = {0: 1, 1: 1, 2: 1, 3: 1}`
- Final result: `count = 2`

### Complexity:
- **Time Complexity**: O(n), where n is the length of the array, as the code iterates through the array once.
- **Space Complexity**: O(n), as the HashMap can store up to n different sums.

This approach leverages the HashMap to efficiently track the cumulative sums and find the required subarrays, making it a clever and efficient solution to the problem.
 */