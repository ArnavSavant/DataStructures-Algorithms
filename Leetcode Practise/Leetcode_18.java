import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_18 {
   // public List<List<Integer>> fourSum(int[] nums, int target) {
   // Set<List<Integer>> answer = new HashSet<>();
   // for (int i = 0; i < nums.length; i++) {
   // for (int j = i + 1; j < nums.length; j++) {
   // Set<Long> set = new HashSet<Long>();
   // for (int k = j + 1; k < nums.length; k++) {
   // long sum = nums[i] + nums[j];
   // sum = sum + nums[k];
   // long fourth = target - sum;
   // if (set.contains(fourth)) {
   // List<Integer> list = new ArrayList<Integer>();
   // list.add(nums[i]);
   // list.add(nums[j]);
   // list.add(nums[k]);
   // list.add((int)(fourth));
   // Collections.sort(list);
   // answer.add(list);
   // }
   // set.add((long)nums[k]);
   // }
   // }
   // }
   // return new ArrayList<>(answer);
   // }

   public List<List<Integer>> fourSum(int nums[], int target) {
      List<List<Integer>> answer = new ArrayList<>();
      Arrays.sort(nums);
      int n = nums.length;
      for (int i = 0; i < n - 1; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
         }
         for (int j = i + 1; j < n; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
               continue;
            }
            int k = j + 1;
            int l = n - 1;
            while (k < l) {
               long sum = nums[i] + nums[j];
               sum = sum + nums[k];
               sum = sum + nums[l];
               if (sum < (long) target) {
                  k++;
               } else if (sum > (long) target) {
                  l--;
               } else {
                  List<Integer> list = new ArrayList<Integer>();
                  list.add(nums[i]);
                  list.add(nums[j]);
                  list.add(nums[k]);
                  list.add(nums[l]);
                  answer.add(list);
                  k++;
                  l--;
                  while (k < l && nums[k] == nums[k - 1]) {
                     k++;
                  }
                  while (k < l && nums[l] == nums[l + 1]) {
                     l--;
                  }
               }
            }
         }
      }
      return answer;
   }
}
/*

### Function Signature:
```java
public List<List<Integer>> fourSum(int nums[], int target)
```

### Purpose:
This function finds all unique quadruplets in the array `nums` that sum up to the target value.

### Parameters:
- `nums[]`: An integer array.
- `target`: An integer representing the target sum.

### Return:
A list of lists containing all unique quadruplets that sum up to the target.

### Detailed Explanation:

1. **Initialization**:
   ```java
   List<List<Integer>> answer = new ArrayList<>();
   Arrays.sort(nums);
   int n = nums.length;
   ```
   - An empty list `answer` is initialized to store the final quadruplets.
   - The array `nums` is sorted to simplify the search process.
   - `n` is the length of the array.

2. **Outer Loops**:
   ```java
   for (int i = 0; i < n - 1; i++) {
      ...
      for (int j = i + 1; j < n; j++) {
         ...
      }
   }
   ```
   - Two nested loops iterate over the array. The outer loop (`i`) starts from the beginning, and the inner loop (`j`) starts from the next element of `i`.

3. **Skip Duplicates**:
   ```java
   if (i > 0 && nums[i] == nums[i - 1]) {
      continue;
   }
   if (j > i + 1 && nums[j] == nums[j - 1]) {
      continue;
   }
   ```
   - These conditions ensure that we skip over duplicate values to avoid considering the same quadruplet multiple times.

4. **Two Pointers**:
   ```java
   int k = j + 1;
   int l = n - 1;
   while (k < l) {
      ...
   }
   ```
   - Two pointers, `k` and `l`, are initialized. `k` starts just after `j`, and `l` starts from the end of the array.
   - The while loop continues until `k` is less than `l`.

5. **Calculate Sum**:
   ```java
   long sum = nums[i] + nums[j];
   sum = sum + nums[k];
   sum = sum + nums[l];
   ```
   - The sum of the four numbers at indices `i`, `j`, `k`, and `l` is calculated.

6. **Check Sum**:
   - If the sum is less than the target, increment `k`.
   - If the sum is greater than the target, decrement `l`.
   - If the sum is equal to the target, a valid quadruplet is found.

7. **Store Quadruplet**:
   ```java
   List<Integer> list = new ArrayList<Integer>();
   list.add(nums[i]);
   list.add(nums[j]);
   list.add(nums[k]);
   list.add(nums[l]);
   answer.add(list);
   ```
   - The found quadruplet is added to the `answer` list.

8. **Skip Duplicates (Again)**:
   ```java
   while (k < l && nums[k] == nums[k - 1]) {
      k++;
   }
   while (k < l && nums[l] == nums[l + 1]) {
      l--;
   }
   ```
   - After finding a valid quadruplet, the code skips over any duplicate values for `k` and `l` to ensure unique quadruplets.

9. **Return Result**:
   ```java
   return answer;
   ```
   - Finally, the list of all unique quadruplets is returned.

### Intuition:
The function uses a combination of sorting, nested loops, and the two-pointer technique. Sorting the array simplifies the process of finding quadruplets and skipping duplicates. The nested loops iterate over potential pairs, and the two-pointer technique efficiently finds the remaining two numbers of the quadruplet.
 */
