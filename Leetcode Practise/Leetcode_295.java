import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_295 {
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        }

        public void addNum(int num) {
            maxHeap.add(num);
            if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return (double) minHeap.peek();
            } else if (maxHeap.size() > minHeap.size()) {
                return (double) maxHeap.peek();
            } else {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
        }
    }
}
/*
### MedianFinder Class Explanation:

The `MedianFinder` class is designed to efficiently find the median of a stream of numbers. It uses two priority queues, a max heap (`maxHeap`) and a min heap (`minHeap`), to maintain the numbers in such a way that the median can be easily determined.

### Data Structures Used:

1. **Max Heap (`maxHeap`):**
   - A priority queue with reverse order to ensure the largest element is at the top.

2. **Min Heap (`minHeap`):**
   - A standard priority queue to store the smaller elements.

### Class Initialization:

- In the constructor (`MedianFinder()`):
  - Initializes the two priority queues: `minHeap` and `maxHeap`.

### Add Number (`addNum` Method):

- Adds a number to the appropriate heap (`maxHeap` or `minHeap`).
- Balances the heaps to ensure that the difference in the number of elements between the two heaps is at most 1.

### Find Median (`findMedian` Method):

- Determines the median based on the current state of the heaps.
- If the sizes of the heaps are equal, the median is the average of the tops of both heaps.
- If one heap has more elements than the other, the median is the top of the heap with more elements.

### Logic and Intuition:

1. **Adding Numbers:**
   - Each new number is initially added to the `maxHeap`.
   - If the current maximum in `maxHeap` is greater than the minimum in `minHeap`, the numbers are swapped to maintain order.
   - The difference in size between `maxHeap` and `minHeap` is then adjusted to ensure balance.

2. **Finding Median:**
   - If the sizes of the two heaps are equal, the median is the average of the tops of both heaps.
   - If one heap is larger, the median is the top of the larger heap.
   - The priority queues are structured in a way that makes determining the median efficient.

### Why this Code Works:

- The use of two heaps ensures that the median can be efficiently determined without the need to sort the entire stream of numbers.
- Balancing the heaps after adding a number ensures that the difference in sizes is at most 1, making finding the median straightforward.

### Time and Space Complexity:

- **Time Complexity:**
  - Adding a number (`addNum`): O(log n), where n is the total number of elements in the heaps.
  - Finding the median (`findMedian`): O(1).

- **Space Complexity:**
  - The space complexity is O(n), where n is the total number of elements in both heaps.

### Summary:

The `MedianFinder` class efficiently maintains a stream of numbers and calculates the median in constant time using two priority queues. The logic of balancing the heaps ensures that the median can be found efficiently, making it a suitable solution for dynamic datasets. The time complexity for adding a number is logarithmic, and finding the median is constant time.
 */