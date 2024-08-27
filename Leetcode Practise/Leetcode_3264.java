import java.util.PriorityQueue;

public class Leetcode_3264 {
    public class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int v, int i) {
            this.value = v;
            this.index = i;
        }

        public int compareTo(Pair p) {
            if (this.value == p.value) {
                return Integer.compare(this.index, p.index);
            }
            return Integer.compare(this.value, p.value);
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair(nums[i], i));
        }
        while (k-- != 0) {
            Pair p = minHeap.poll();
            minHeap.add(new Pair(p.value * multiplier, p.index));
        }
        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            nums[p.index] = p.value;
        }
        return nums;
    }
}
