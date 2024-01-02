import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        for (char x : tasks) {
            if (mp.containsKey(x)) {
                mp.put(x, mp.get(x) + 1);
            } else {
                mp.put(x, 1);
            }
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.addAll(mp.values());
        int result = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int time = 0;
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    list.add(maxHeap.poll() - 1);
                    time++;
                }
            }
            for (int t : list) {
                if (t > 0) {
                    maxHeap.add(t);
                }
            }
            result = result + (maxHeap.isEmpty() ? time : n + 1);
        }
        return result;
    }
}
/*
 The provided code is an implementation of a task scheduling problem where tasks need to be executed in a specific order with a cooldown period between identical tasks. The goal is to find the minimum time required to execute all the tasks.

Logic and Intuition:
Frequency Counting:

The code starts by creating a frequency map (mp) to count the occurrences of each task in the tasks array.
PriorityQueue for Maximum Frequency:

The code uses a PriorityQueue (maxHeap) to keep track of the frequencies in descending order. This means the task with the maximum frequency will be at the top of the heap.
Task Execution Loop:

The main loop continues until the heap is empty, meaning all tasks have been scheduled.
In each iteration of the loop, a list (list) is used to store the frequencies of tasks that are being scheduled in the current time unit.
A variable time is used to track the time units passed in the current iteration.
Scheduling Tasks:

The inner loop runs for n + 1 iterations, where n is the cooldown period.
In each iteration, the code polls a task from the heap (task with maximum frequency) and decrements its frequency.
The task is added to the list, and the time is incremented.
Restoring Heap with Updated Frequencies:

After scheduling tasks for the current time unit, the code iterates over the list and adds tasks back to the heap with updated frequencies if their frequencies are greater than zero.
Calculating Result:

The result is updated by adding the number of time units spent in the current iteration.
If the heap is empty, it means all tasks are scheduled, and the loop will terminate. Otherwise, the cooldown period is added to the result.
Final Result:

The final result represents the minimum time required to execute all tasks with the given cooldown period.
Time Complexity:
The time complexity is primarily determined by the operations on the PriorityQueue (maxHeap).
Each task is processed at most twice (once when initially added to the heap and once when retrieved from the heap in the main loop).
Therefore, the time complexity is O(N log N), where N is the number of tasks.
Space Complexity:
The space complexity is O(U), where U is the number of unique tasks. This is due to the storage of task frequencies in the PriorityQueue and the frequency map.
Summary:
The code efficiently schedules tasks with a cooldown period by using a priority queue to prioritize tasks with higher frequencies. The logic ensures that the tasks are scheduled in a way that minimizes the total execution time. The time complexity is O(N log N), and the space complexity is O(U), where N is the number of tasks and U is the number of unique tasks.







 */