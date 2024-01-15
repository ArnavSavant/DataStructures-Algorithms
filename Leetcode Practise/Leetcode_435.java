import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_435 {
    public class customComparator implements Comparator<int[]> {
        public int compare(int a[], int b[]) {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return 0;
        }
        Arrays.sort(intervals, new customComparator());
        int currEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < currEnd) {
                currEnd = Math.min(currEnd, intervals[i][1]);
                count++;
            } else {
                currEnd = intervals[i][1];
            }
        }
        return count;
    }
}
/*
This Java code snippet is designed to solve a specific problem in interval scheduling, commonly found in computational geometry or in scheduling algorithms. The problem seems to be about finding the minimum number of intervals that need to be removed so that the remaining intervals don't overlap. Let's analyze the code in detail:

### 1. **Code Explanation**

#### Custom Comparator
- **Class `customComparator`**: This class implements the `Comparator<int[]>` interface to define a custom sorting order for interval arrays.
- **Method `compare(int[] a, int[] b)`**: It compares two intervals, `a` and `b`. If the start times (`a[0]` and `b[0]`) are the same, it sorts based on the end times (`a[1]` and `b[1]`). Otherwise, it sorts by start times.

#### Main Method `eraseOverlapIntervals(int[][] intervals)`
- **Variable Initialization**: `n` stores the number of intervals. The method returns `0` if there's only one interval since there's nothing to overlap.
- **Sorting Intervals**: The intervals are sorted using `Arrays.sort()` with the custom comparator.
- **Overlap Removal Logic**: The method iterates through the sorted intervals, counting overlaps and adjusting `currEnd` to keep track of the end of the current non-overlapping interval.

### 2. **Logic of the Code**
The key logic is to sort the intervals by start time and then by end time (if start times are equal). Once sorted, the code iterates through the intervals, checking for overlaps. The count of overlaps (`count`) is incremented for each overlapping interval found, and the `currEnd` is adjusted accordingly to keep track of the non-overlapping intervals.

### 3. **Developing Intuition and Identifying Correct Approaches**
- **Approach**: The problem is a variant of the interval scheduling optimization problem. The intuition is that sorting the intervals helps in linearly comparing overlapping intervals.
- **Data Structure & Algorithm**: The chosen data structures are basic arrays, and the algorithm involves sorting and linear traversal, which is efficient and straightforward for this problem.

### 4. **Why the Code Works**
- **Efficient Sorting and Simple Logic**: By sorting the intervals, the code ensures that at each step, it's only necessary to consider the current and the next interval for overlap. This reduces the problem to a simple comparison task.
- **Handling Edge Cases**: The initial check for a single interval and the use of `Math.min` to update `currEnd` correctly handles edge cases.

### 5. **Time and Space Complexity Calculations**
- **Time Complexity**: 
  - Sorting the intervals takes O(n log n) time.
  - The single traversal of the list takes O(n) time.
  - Overall, the time complexity is O(n log n).
- **Space Complexity**:
  - The space complexity is O(1) or constant space, as no extra space is used apart from variables.

This code is an excellent example of combining sorting with a greedy algorithm to solve an optimization problem efficiently.
 */