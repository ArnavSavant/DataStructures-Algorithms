import java.util.PriorityQueue;

public class Leetcode_703 {
    class KthLargest {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int x : nums) {
                minHeap.add(x);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }
}
/*
Overview:
This code implements the Kth Largest Element in a Stream using a priority queue (min heap). The KthLargest class has a constructor that initializes the class with a parameter 'k' and an array of initial elements 'nums.' It maintains a min heap of the k largest elements in 'nums.' The class also provides a method 'add' to add a new element to the stream and return the kth largest element at any point.

Logic and Intuition:
Constructor:
Initialization:
The class initializes a min heap (minHeap) to store the k largest elements.
The parameter 'k' is stored in the class variable.
Iterate through the initial elements (nums) and add each element to the heap.
If the size of the heap exceeds 'k,' remove the smallest element (top of the min heap).
add Method:
Add New Element:

When the add method is called with a new element 'val,' add 'val' to the min heap.
Again, if the size of the heap exceeds 'k,' remove the smallest element.
Return Kth Largest:

After adding the new element, return the current kth largest element, which is at the top of the min heap.
Why this Code Works:
The min heap is used to maintain the k largest elements at any given time.
By using a min heap, we always have quick access to the smallest element among the k largest elements.
When adding a new element, if the size of the heap exceeds 'k,' we remove the smallest element, ensuring that we only keep the k largest elements.
Time and Space Complexity:
Constructor:

The constructor iterates through 'nums,' performing heap operations for each element, resulting in a time complexity of O(n log k), where 'n' is the size of 'nums.'
The space complexity is O(k) due to the min heap storing the k largest elements.
Add Method:

The add method performs heap operations, which have a time complexity of O(log k).
The space complexity remains O(k) as we are only adding one element at a time.
Summary:
The KthLargest class maintains the k largest elements using a min heap. The constructor initializes the class with the k largest elements from the initial array, and the add method allows adding new elements while keeping track of the kth largest element efficiently. The time complexity for both constructor and add method is O(log k), and the space complexity is O(k).







 */