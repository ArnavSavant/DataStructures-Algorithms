import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_1353 {
    public class endDayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new endDayComparator());
        int maxEvents = 0;
        int lastEndTime = 0;
        int lastStartTime = 0;
        for (int[] event : events) {
            if (event[0] >= lastEndTime) {
                lastEndTime = event[1];
                lastStartTime = event[0];
                maxEvents++;
            } else if (lastStartTime == event[0] && lastEndTime == event[1]) {
                maxEvents++;
            }
        }
        return maxEvents;
    }
}
/*
The Java code you've shared defines a method `maxEvents(int[][] events)` which is designed to solve a scheduling problem, often encountered in algorithms related to sorting and greedy approaches. The problem is to find the maximum number of events one can attend, given their start and end times.

### 1. **Code Explanation**

#### Custom Comparator (`endDayComparator`)
- **Implements `Comparator<int[]>` Interface**: For comparing integer arrays (events).
- **`compare(int[] a, int[] b)` Method**: It sorts the events primarily by their end times (`a[1]` and `b[1]`). If the end times are equal, it sorts by start times (`a[0]` and `b[0]`).

#### Main Method (`maxEvents(int[][] events)`)
- **Sorting Events**: The `events` array is sorted using the custom comparator.
- **Variables Initialization**: 
  - `maxEvents`: Counts the number of events that can be attended.
  - `lastEndTime` and `lastStartTime`: Track the end and start time of the last attended event.

- **Iterating Through Events**:
  - The method iterates through each event after sorting.
  - If the start time of the current event is after or equal to `lastEndTime`, it updates `lastEndTime` and `lastStartTime`, and increments `maxEvents`.
  - If the current event has the same start and end time as the last attended event, it also increments `maxEvents`.

### 2. **Logic of the Code**
The logic is based on the greedy approach where the events are sorted by their end time to prioritize attending events that finish earlier. This approach maximizes the chances of attending more events as it frees up the schedule sooner.

### 3. **Developing Intuition and Identifying Correct Approaches**
- **Recognizing the Problem Type**: This problem fits the greedy algorithm paradigm, where sorting events based on a specific criterion (end time) helps make locally optimal choices.
- **Algorithm Choice**: Sorting and then iterating through the sorted list is a classic approach for problems where the order of elements can lead to an optimal solution.

### 4. **Why the Code Works**
- **Efficient Sorting and Selection**: By sorting the events based on their end times, the algorithm ensures that the earliest finishing events are considered first, increasing the total count of events that can be attended.
- **Handling Overlapping Events**: The condition `event[0] >= lastEndTime` ensures that overlapping events are not counted unless they have the same start and end time as the last attended event.

### 5. **Time and Space Complexity Calculations**
- **Time Complexity**: 
  - Sorting the array takes O(n log n) time.
  - The single iteration through the sorted list takes O(n) time.
  - Overall, the time complexity is O(n log n).
- **Space Complexity**:
  - The space complexity is O(1) or constant, as no additional space proportional to the input size is used.

This method is an exemplary demonstration of how sorting can be leveraged in greedy algorithms to efficiently solve scheduling problems.
 */