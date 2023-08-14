import java.util.SortedSet;
import java.util.TreeSet;

public class Leetcode_128 {
   public int longestConsecutive(int[] nums) {
      SortedSet<Integer> set = new TreeSet<Integer>();
      for (int i = 0; i < nums.length; i++) {
         set.add(nums[i]);
      }
      int count = 0;
      int maxCount = Integer.MIN_VALUE;
      int prev = -1;
      for (int n : set) {
         if (count == 0) {
            count++;
            maxCount = Math.max(maxCount, count);
         } else if (count > 0) {
            if (prev + 1 == n) {
               count++;
               maxCount = Math.max(maxCount, count);
            } else {
               count = 1;
            }
         }
         prev = n;
      }
      return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
   }
}

/*

1. **Initialization**: 
   - A `SortedSet` named `set` is created to store the unique integers from the input array `nums`. Since it's a `TreeSet`, it will automatically sort the elements in ascending order.
   - Variables `count` and `maxCount` are initialized to keep track of the current consecutive sequence length and the maximum consecutive sequence length found so far, respectively.
   - Variable `prev` is initialized to `-1` and will be used to keep track of the previous integer in the sorted set.

2. **Populating the SortedSet**:
   - A loop iterates through the `nums` array, adding each integer to the `set`. Since `set` is a `SortedSet`, duplicates are automatically removed, and the elements are sorted.

3. **Iterating Through the Sorted Set**:
   - A loop iterates through the sorted set `set`.
   - If `count` is `0`, it means this is the first element in the set, so `count` is incremented, and `maxCount` is updated if necessary.
   - If `count` is greater than `0`, the code checks if the current integer `n` is consecutive to the previous integer `prev`. If it is, `count` is incremented, and `maxCount` is updated if necessary. If not, `count` is reset to `1`, indicating a new sequence has started.
   - `prev` is updated with the current integer `n`.

4. **Return Value**:
   - If `maxCount` remains at its initialized value (`Integer.MIN_VALUE`), it means the input array was empty, and the function returns `0`.
   - Otherwise, `maxCount` is returned, representing the length of the longest consecutive elements sequence.

### Intuition:
The intuition behind this code is to leverage a sorted set to handle both the sorting and removal of duplicates in one step. By iterating through the sorted set, the code can easily identify consecutive sequences and keep track of the longest one.

### Time Complexity:
The time complexity of this code is \(O(n \log n)\), where \(n\) is the length of the input array. This is due to the sorting operation in the `TreeSet`.

### Space Complexity:
The space complexity is \(O(n)\), as a set with at most \(n\) elements is created.

 */
