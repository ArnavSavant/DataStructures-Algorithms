import java.util.ArrayList;

public class Leetcode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<Integer[]> temp = new ArrayList<>();
        int currStart = newInterval[0];
        int currEnd = newInterval[1];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if ((intervals[i][1] >= currStart && intervals[i][1] <= currEnd)
                    || (intervals[i][0] <= currEnd && intervals[i][1] >= currEnd)
                    || (intervals[i][0] >= currStart && intervals[i][1] <= currEnd)) {
                currStart = Math.min(currStart, intervals[i][0]);
                currEnd = Math.max(currEnd, intervals[i][1]);
                flag = true;
            } else {
                if (flag) {
                    temp.add(new Integer[] { currStart, currEnd });
                    currStart = intervals[i][0];
                    currEnd = intervals[i][1];
                } else {
                    if (currEnd < intervals[i][0]) {
                        temp.add(new Integer[] { currStart, currEnd });
                        currStart = intervals[i][0];
                        currEnd = intervals[i][1];
                        flag = false;
                    } else {
                        temp.add(new Integer[] { intervals[i][0], intervals[i][1] });
                    }
                }
            }
        }
        temp.add(new Integer[] { currStart, currEnd });
        int ans[][] = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i][0] = temp.get(i)[0];
            ans[i][1] = temp.get(i)[1];
        }
        return ans;
    }
}
/*
The Java method `insert(int[][] intervals, int[] newInterval)` is designed to insert a new interval into a list of non-overlapping intervals and merge any overlapping intervals. It's a common problem in computational geometry and interval scheduling.

### 1. **Code Explanation**

- **Initialization**:
  - `n`: The number of intervals in the given array.
  - `temp`: An `ArrayList` to store the merged intervals.
  - `currStart` and `currEnd`: Variables to track the start and end of the current interval being processed, initially set to the start and end of `newInterval`.
  - `flag`: A boolean flag to track if the new interval has been merged.

- **Iterating through Intervals**:
  - The method iterates over each interval in `intervals`.
  - It checks if the current interval overlaps with the interval defined by `currStart` and `currEnd`.
    - If there's an overlap, `currStart` and `currEnd` are updated to the merged interval.
    - If there's no overlap and the `flag` is `true`, it adds the current merged interval to `temp` and resets `currStart` and `currEnd` to the current interval.
    - If there's no overlap and `currEnd` is less than the start of the current interval, it adds the current merged interval to `temp` and sets the flag to `false`.
    - Otherwise, it adds the current interval to `temp`.

- **Final Addition and Conversion**:
  - Adds the last processed interval to `temp`.
  - Converts `temp` into a 2D array `ans` to return.

### 2. **Logic of the Code**
The logic revolves around merging overlapping intervals. If the current interval overlaps with the interval to insert, it merges them. Otherwise, it adds the non-overlapping intervals to the result. The method ensures that all intervals, including the new one, are processed and merged if necessary.

### 3. **Developing Intuition and Identifying Correct Approaches**
- **

Recognizing the Problem Type**: This problem is a classic example of interval merging. It requires understanding how intervals interact (overlap, are disjoint, etc.).
- **Data Structure Choice**: Using an `ArrayList` allows for dynamic addition of intervals, which is useful as the number of merged intervals isn't known in advance.
- **Algorithm**: The algorithm iteratively checks each interval against the current interval being merged (initially the new interval) and updates the current interval or adds it to the list based on overlap conditions.

### 4. **Why the Code Works**
- **Merging Logic**: The method correctly identifies overlapping intervals using conditional checks and merges them by updating `currStart` and `currEnd`.
- **Handling Non-Overlapping Intervals**: It adds non-overlapping intervals directly to `temp`.
- **Final Interval Addition**: The last interval is added after the loop to ensure all intervals, including the newly merged one, are included.
- **Correct Ordering**: Since the input intervals are non-overlapping and sorted, the method maintains this order in the output.

### 5. **Time and Space Complexity Calculations**
- **Time Complexity**: 
  - The function iterates once through the array, leading to a time complexity of O(n), where n is the number of intervals.
- **Space Complexity**:
  - The space complexity is O(n) due to the additional `ArrayList` (`temp`) used to store the merged intervals.

In summary, this method is an efficient way to merge intervals, taking advantage of sorted, non-overlapping input intervals. It ensures that all intervals are processed, and overlapping intervals are merged correctly, maintaining the order of intervals.
 */