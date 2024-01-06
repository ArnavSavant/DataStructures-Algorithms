import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_347 {
    public class Pair implements Comparable<Pair> {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return Integer.compare(this.key, o.key);
            }
            return Integer.compare(this.value, o.value);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>();
        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int ans[] = new int[k];
        int i = 0;
        for (Pair p : maxHeap) {
            ans[i] = p.key;
            i++;
        }
        return ans;
    }
}
/*
Overview:
This code finds the k most frequent elements in an array using a PriorityQueue (max heap) and a custom class Pair to represent elements with their frequencies. The goal is to return an array containing the k most frequent elements in descending order of their frequencies.

Logic and Intuition:
Custom Pair Class:

A Pair class is defined to represent elements with their frequencies. The class implements the Comparable interface to allow comparison based on frequency and element values.
Frequency Counting:

A HashMap (mp) is used to count the frequencies of elements in the input array (nums).
PriorityQueue for K Most Frequent:

A PriorityQueue (maxHeap) is used to keep track of the k most frequent elements.
The PriorityQueue is configured as a max heap using the custom Pair class with comparisons based on frequency and element values.
While iterating through the frequency map, pairs are added to the maxHeap. If the size exceeds k, the least frequent element is removed.
Construct Result Array:

An array ans is created to store the result.
Iterate through the maxHeap and store the keys (elements) in the ans array.
Why this Code Works:
The PriorityQueue (maxHeap) ensures that the elements with higher frequencies are prioritized, and the heap only contains the k most frequent elements.
The custom Pair class and its compareTo method allow sorting based on frequency and element values.
By iterating through the frequency map and maintaining the maxHeap, we efficiently identify the k most frequent elements.
Time and Space Complexity:
Time Complexity:

Constructing the frequency map takes O(n) time, where n is the length of the input array nums.
Inserting and removing elements from the maxHeap is done k times, resulting in O(k log k) operations.
The overall time complexity is O(n + k log k).
Space Complexity:

The space complexity is O(n) for the frequency map.
The space required for the maxHeap is O(k).
The overall space complexity is O(n + k).
Summary:
The code efficiently identifies the k most frequent elements in an array using a max heap and a frequency map. The PriorityQueue ensures that the k most frequent elements are maintained, and the result is constructed by iterating through the heap. The time complexity is O(n + k log k), and the space complexity is O(n + k).
 */