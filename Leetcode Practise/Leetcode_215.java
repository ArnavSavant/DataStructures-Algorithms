import java.util.PriorityQueue;
public class Leetcode_215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > (k)) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
/*
Intuition:
The code aims to find the kth largest element in an array nums. It achieves this goal by using a min-heap (implemented as a PriorityQueue). The min-heap is maintained in such a way that it always contains the k largest elements encountered so far. By the end of the loop, the min-heap will have the k largest elements, and the top of the heap will be the kth largest element.

Logic:

The code initializes a min-heap (PriorityQueue<Integer> minHeap) to store elements in ascending order.
It iterates through each element in the array nums and adds it to the min-heap.
After adding an element, it checks if the size of the min-heap exceeds k. If so, it removes the smallest element from the heap (minHeap.poll()). This ensures that the min-heap always contains the k largest elements encountered so far.
After processing all elements, the min-heap contains the k largest elements, and the top of the heap (accessed using minHeap.poll()) is the kth largest element.
Why it Works:
The min-heap is employed to efficiently maintain the k largest elements. By always keeping the heap size at most k, it ensures that it only contains the k largest elements encountered during the iteration. The smallest element among these k largest elements will be at the top of the min-heap, making it easy to find the kth largest element.

Complexities:

Time Complexity: The time complexity of adding an element to a min-heap and removing the smallest element (add() and poll() operations) is O(log k), where k is the size of the heap. The loop runs n times (the length of the input array), so the overall time complexity is O(n log k).
Space Complexity: The space complexity is O(k) as the min-heap is only storing the k largest elements.
Example:
Consider nums = [3, 1, 4, 2, 2, 1] and k = 3. The min-heap would be updated as follows:

Add 3 to the heap: [3]
Add 1 to the heap: [1, 3]
Add 4 to the heap: [1, 3, 4]
Add 2 to the heap: [2, 3, 4]
Add 2 to the heap: [2, 2, 3] (size exceeds k, so remove the smallest element 2)
Add 1 to the heap: [1, 2, 3] (size exceeds k, so remove the smallest element 1)
After processing all elements, the min-heap [1, 2, 3] contains the 3 largest elements, and minHeap.poll() would return 1, which is the 3rd largest element in the array.

In conclusion, this code efficiently finds the kth largest element using a min-heap, and its time complexity makes it suitable for scenarios where k is much smaller than n.
 */