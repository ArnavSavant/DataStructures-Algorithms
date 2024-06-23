import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_1428 {
    class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int v, int ind) {
            this.value = v;
            this.index = ind;
        }

        public int compareTo(Pair o) {
            if (o.value == this.value) {
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(this.value, o.value);
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            minHeap.add(new Pair(nums[j], j));
            maxHeap.add(new Pair(nums[j], j));
            int diff = maxHeap.peek().value - minHeap.peek().value;
            while (i < j && diff > limit) {
                i = Math.min(minHeap.peek().index, maxHeap.peek().index) + 1;
                while (minHeap.peek().index < i) {
                    minHeap.poll();
                }
                while (maxHeap.peek().index < i) {
                    maxHeap.poll();
                }
                diff = maxHeap.peek().value - minHeap.peek().value;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
