import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int weight : stones) {
            maxHeap.add(weight);
        }
        while (maxHeap.size() > 0) {
            if (maxHeap.size() == 1) {
                break;
            }
            int w1 = maxHeap.poll();
            int w2 = maxHeap.poll();
            if (w1 != w2) {
                maxHeap.add(Math.abs(w1 - w2));
            }
        }
        if (maxHeap.isEmpty()) {
            return -1;
        }
        return maxHeap.poll();
    }
}
/*
 * ### Documentation for the `lastStoneWeight` Method
 * 
 * #### Logic of the Code
 * 
 * The `lastStoneWeight` method simulates a process where stones are smashed
 * together based on their weights, following these rules:
 * - Two stones at a time are picked up, and their weights are compared.
 * - If the stones have the same weight, both stones are destroyed.
 * - If the weights are different, both stones are smashed, and a new stone is
 * created with the weight equal to the absolute difference of the two stones'
 * weights. This new stone is then put back into the pool of stones.
 * - This process is repeated until either one stone is left or no stones are
 * left.
 * 
 * The method implements this process using a max heap (`PriorityQueue` in Java
 * with a reverse order comparator) to efficiently manage the stones based on
 * their weights. This allows for constant-time access to the heaviest stones
 * that need to be smashed together.
 * 
 * #### Intuition to Develop This Logic/Approach
 * 
 * The approach is designed around the priority queue data structure to
 * efficiently handle the requirement of repeatedly accessing and removing the
 * two heaviest stones. A max heap is ideal for this task as it maintains the
 * stones in descending weight order, ensuring the process's rules can be
 * applied efficiently. The use of a max heap simplifies the implementation by
 * abstracting the sorting and selection of stones to smash.
 * 
 * #### Why This Code Works
 * 
 * This code works effectively for the problem due to the following reasons:
 * - **Efficient Selection of Stones**: By using a max heap, the method can
 * quickly and efficiently select the two heaviest stones to smash together, as
 * required by the problem statement.
 * - **Correct Handling of Edge Cases**: The method properly handles cases where
 * no stones are left (returns -1) or only one stone is left (returns the weight
 * of the remaining stone), aligning with the expected outcomes.
 * - **Accurate Simulation of the Smashing Process**: The use of absolute
 * difference for stones with different weights and the removal of stones with
 * equal weights accurately simulates the process described in the problem
 * statement.
 * 
 * #### Time and Space Complexities
 * 
 * - **Time Complexity**: The time complexity of this method is O(n log n),
 * where n is the number of stones. Inserting n stones into the priority queue
 * takes O(n log n) time, and each subsequent operation (insertion or removal)
 * within the while loop also operates in O(log n) time. Given that the while
 * loop can run up to n times in the worst case, the overall complexity is
 * dominated by these operations.
 * 
 * - **Space Complexity**: The space complexity is O(n), as the priority queue
 * may contain up to n elements if all stones are inserted into it.
 * 
 * The `lastStoneWeight` method effectively simulates the stone-smashing process
 * with an optimized approach using a max heap, providing a solution that is
 * both intuitive and efficient in handling the problem's requirements.
 */