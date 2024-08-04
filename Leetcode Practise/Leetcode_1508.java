import java.util.PriorityQueue;

public class Leetcode_1508 {
    public class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int v, int i) {
            this.value = v;
            this.index = i;
        }

        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(this.value, o.value);
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(new Pair(nums[i], i));
        }
        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < right; i++) {
            Pair p = minHeap.poll();
            if (i >= left - 1) {
                ans = (ans + p.value) % mod;
            }
            if (p.index + 1 < n) {
                minHeap.add(new Pair(p.value + nums[p.index + 1], p.index + 1));
            }
        }
        return ans;
    }
}
