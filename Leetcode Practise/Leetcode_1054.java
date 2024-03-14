import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_1054 {
    public class Pair implements Comparable<Pair> {
        int barcode;
        int frequency;

        Pair(int barcode, int frequency) {
            this.barcode = barcode;
            this.frequency = frequency;
        }

        public int compareTo(Pair o) {
            if (this.frequency == o.frequency) {
                return Integer.compare(this.barcode, o.barcode);
            }
            return Integer.compare(this.frequency, o.frequency);
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int ans[] = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int barcode : barcodes) {
            mp.put(barcode, mp.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        int index = 0;
        while (index < n) {
            Pair p = maxHeap.poll();
            if (index == 0) {
                ans[index] = p.barcode;
                p.frequency--;
            } else {
                if (ans[index - 1] == p.barcode) {
                    Pair temp = maxHeap.poll();
                    ans[index] = temp.barcode;
                    temp.frequency--;
                    if (temp.frequency != 0) {
                        maxHeap.add(temp);
                    }
                } else {
                    ans[index] = p.barcode;
                    p.frequency--;
                }
            }
            if (p.frequency != 0) {
                maxHeap.add(p);
            }
            index++;
        }
        return ans;
    }
}
/*
### Documentation for the `rearrangeBarcodes` Method

#### Logic of the Code

The `rearrangeBarcodes` method aims to rearrange an array of barcodes so that no two adjacent barcodes are the same. It follows these steps:

1. **Frequency Map Creation**: It first creates a frequency map (`mp`) to count how many times each barcode appears in the input array.
2. **Priority Queue Initialization**: It then initializes a max heap (`PriorityQueue`) based on the frequencies of each barcode, with the help of a custom `Pair` class that stores a barcode and its frequency. The `Pair` class implements `Comparable` to ensure that the priority queue orders elements primarily by frequency (in descending order) and secondarily by barcode value (in ascending order) in case of frequency ties.
3. **Rearrangement Process**: The method then iterates through the positions in the result array (`ans`), each time selecting the most frequent barcode that does not match the previously placed barcode (if any). It decreases the selected barcode's frequency after placing it and re-adds it to the max heap if its frequency is not zero.
4. **Handling Adjacent Duplicates**: If the most frequent barcode is the same as the last placed barcode, it temporarily removes the top element and selects the next most frequent barcode to ensure no two adjacent barcodes are the same.

#### Intuition to Develop This Logic/Approach

The intuition behind using a max heap sorted by frequency is to always attempt to place the most frequent barcodes first, thereby reducing the chance of having no valid barcode to place next as the arrangement progresses. The `Pair` class and its comparison logic ensure that the priority queue operates correctly according to the problem's requirements. This approach guarantees that the barcode with the highest remaining frequency (and, in the case of a tie, the lowest numerical barcode) is considered next, thus efficiently avoiding adjacent duplicates.

#### Why This Code Works

This code works effectively because:
- **Priority Queue Management**: It dynamically manages barcodes based on their frequencies, ensuring that the most frequent barcodes are placed first while avoiding adjacent duplicates.
- **Custom Sorting Logic**: The custom comparison logic in the `Pair` class ensures that barcodes are selected in an order that prioritizes higher frequencies while providing a deterministic way to choose among barcodes with equal frequencies.
- **Dynamic Frequency Updates**: By decrementing the frequency of each used barcode and only re-adding it to the max heap if its frequency is non-zero, the algorithm efficiently keeps track of remaining barcodes.

#### Time and Space Complexities

- **Time Complexity**: The time complexity of this method is O(n log k), where n is the number of barcodes, and k is the number of unique barcodes. This is because inserting into and removing from the priority queue takes O(log k) time, and these operations are performed for each of the n barcodes.
  
- **Space Complexity**: The space complexity is O(k), where k is the number of unique barcodes. This accounts for the space needed to store the frequency map and the max heap. The result array `ans` does not contribute to the space complexity as it is required for the output.

The `rearrangeBarcodes` method offers an efficient and effective solution for rearranging barcodes to avoid adjacent duplicates, leveraging a priority queue to manage barcode frequencies dynamically.
 */