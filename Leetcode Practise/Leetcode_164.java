import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_164 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            maxHeap.add(heights[i + 1] - heights[i]);
        }
        int max = 1;
        int ind = 0;
        while (ind<n-1) {
            int diff = heights[ind + 1] - heights[ind];
            if (diff < 0) {
                ind++;
                continue;
            } else if (diff == maxHeap.peek() && ladders > 0) {
                ladders--;
            } else {
                if (bricks < diff) {
                    if (ladders > 0) {
                        ladders--;
                    } else {
                        break;
                    }
                } else {
                    bricks = bricks - diff;
                }
            }
            if (diff == maxHeap.peek()) {
                maxHeap.poll();
            }
            max++;
            ind++;
        }
        return max;
    }
}
/*
 * The provided code snippet is designed to solve a problem where you are given
 * an array of integers `heights` representing the heights of buildings in a
 * line, a number of `bricks`, and a number of `ladders`. The goal is to
 * determine the furthest building you can reach by either jumping to it (if the
 * next building is of equal or lesser height) or using bricks/ladders to
 * overcome the height difference when moving to a higher building. Bricks can
 * be used to cover any height difference, but each ladder can be used to cover
 * one height difference regardless of its size. The main logic of the function
 * and its components are detailed below.
 * 
 * ### Main Logic
 * 
 * - **PriorityQueue `maxHeap`**: A max heap is initialized to store the height
 * differences between consecutive buildings in descending order. This data
 * structure is used to keep track of the largest height differences
 * encountered, which is crucial for optimally using the ladders.
 * - **Iteration Over Buildings**: The loop iterates over each building (except
 * the last one) to calculate the height difference to the next building. These
 * differences are added to the `maxHeap`.
 * - **Variables**: `max` keeps track of the maximum number of buildings you can
 * reach, including the starting building. `ind` is the current index in the
 * `heights` array.
 * 
 * ### Core Algorithm
 * 
 * - As the loop iterates through each building, it calculates the difference in
 * height (`diff`) to the next building. If this difference is negative or zero,
 * it implies no bricks or ladders are needed, and the loop simply moves to the
 * next building.
 * - If the height difference is equal to the current maximum height difference
 * (`maxHeap.peek()`), and a ladder is available, a ladder is used by
 * decrementing the `ladders` count. This strategy ensures ladders are used for
 * the largest height differences first, which is the optimal use of ladders.
 * - If the height difference is not covered by a ladder, it checks if there are
 * enough bricks to cover the `diff`. If not, and a ladder is available, a
 * ladder is used. Otherwise, if there are insufficient bricks and no ladders,
 * the loop breaks as you can't move further.
 * - After dealing with the height difference by either using bricks or a
 * ladder, if the `diff` equals the current max height difference, that
 * difference is removed from the heap.
 * - The `max` and `ind` variables are incremented to move to the next building.
 * 
 * ### Corrections and Clarifications
 * 
 * The original code's logic, particularly around the use of `maxHeap`, seems
 * flawed or at least not optimally implemented for the described goal. It adds
 * all height differences to the heap and iterates through buildings, attempting
 * to use the heap to manage ladders. However, the actual logic should
 * prioritize using ladders for the largest jumps that can't be covered by
 * bricks, not just any largest jump seen so far. Moreover, the heap's contents
 * are not directly correlated with the choices of using bricks or ladders in an
 * optimal way because it doesn't consider the sequential nature of the journey
 * across buildings.
 * 
 * A corrected approach would involve adding differences to the heap only when
 * encountering a building that requires going upwards, using bricks for smaller
 * differences as much as possible, and reserving ladders for the largest
 * differences encountered when bricks run out or are better saved for future,
 * smaller increments.
 * 
 * ### Complexity Analysis
 * 
 * - **Time Complexity**: O(N log N), where N is the number of buildings. This
 * complexity arises from adding all height differences to the heap and
 * potentially removing them, each operation taking O(log N) time due to the
 * heap.
 * - **Space Complexity**: O(N) for storing the height differences in the
 * `maxHeap`.
 * 
 * ### Conclusion
 * 
 * While the intention behind the code seems to aim at optimizing the use of
 * bricks and ladders to reach the furthest building, the implementation does
 * not efficiently achieve this due to the indiscriminate use of the heap for
 * all height differences. For a more accurate and efficient solution, a refined
 * approach that strategically uses ladders for the largest necessary jumps and
 * bricks for smaller increments would be needed, with careful consideration of
 * when each resource is used as the iteration progresses.
 */