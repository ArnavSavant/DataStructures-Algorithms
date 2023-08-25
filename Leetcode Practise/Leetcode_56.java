import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][0]);
            } else {
                list.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] { start, end });
        return list.toArray(new int[0][]);
    }
}

/*
### Goal:

Given a collection of intervals, merge any overlapping intervals.

### Example:

Given: [[1,3],[2,6],[8,10],[15,18]]
Return: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, they should be merged to [1,6].

### Code Explanation:

1. `List<int[]> list = new ArrayList<int[]>();`  
   * This line creates a new list that will be used to store the merged intervals.

2. `Arrays.sort(intervals, (a, b) -> a[0] - b[0]);`  
   * This line sorts the `intervals` array based on the start values of each interval.  
   * Lambda function `(a, b) -> a[0] - b[0]` sorts the intervals in ascending order of their start times.

3. `int start = intervals[0][0];` and `int end = intervals[0][1];`  
   * Initializing the `start` and `end` with the first interval's start and end times.

4. Loop through the intervals:
   ```java
   for (int i = 0; i < n; i++) {
       ...
   }
   ```

   * `if (intervals[i][0] <= end) {`  
     This checks if the start of the current interval is less than or equal to the end of the previous interval (i.e., they overlap).

     - `end = Math.max(end, intervals[i][1]);`  
       If they overlap, then we update the `end` to the maximum of the current `end` and the end of the overlapping interval.  
       **Note**: There is a small mistake here. The correct line should be `end = Math.max(end, intervals[i][1]);`, instead of `intervals[i][0]`.

   * `else {`  
     This part handles the case when the current interval does not overlap with the previous merged interval.
     - `list.add(new int[] { start, end });`  
       Since they don't overlap, the current merged interval (from `start` to `end`) is added to the list.
     - `start = intervals[i][0];` and `end = intervals[i][1];`  
       Then, the start and end times are updated to the current interval's values.

5. After exiting the loop:
   * `list.add(new int[] { start, end });`  
     The last merged interval is added to the list. This is required because the loop might exit without adding the last merged interval to the list.

6. Finally:
   * `return list.toArray(new int[0][]);`  
     The merged intervals list is converted back to an array and returned.

### Intuition:

The primary intuition behind this solution is that once the intervals are sorted by their starting times, any overlapping intervals will be next to each other in the sorted list. So, while iterating through the sorted list, you just need to check if the current interval overlaps with the previously processed interval.

By maintaining the `start` and `end` variables, you keep updating the range of the currently merging interval. If you encounter a non-overlapping interval, you store the merged range and start a new range.
 */
