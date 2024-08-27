import java.util.PriorityQueue;

public class Leetcode_3266 {
    public class Pair implements Comparable<Pair> {
        long value;
        int index;

        Pair(long v, int i) {
            this.value = v;
            this.index = i;
        }

        public int compareTo(Pair p) {
            if (this.value == p.value) {
                return Integer.compare(this.index, p.index);
            }
            return Long.compare(this.value, p.value);
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minHeap.add(new Pair(nums[i], i));
            max = Math.max(max, nums[i]);
        }
        int mod = 1000000007;
        while (k > 0) {
            Pair pair = minHeap.poll();
            long value = pair.value;
            int index = pair.index;
            if (value * multiplier > max) {
                minHeap.add(pair);
                break;
            } else {
                minHeap.add(new Pair((value * multiplier) % mod, index));
            }
            k--;
        }
        int newK = k / n;
        int rem = k % n;
        long first = powerSum(multiplier, newK, mod);
        long second = powerSum(multiplier, newK + 1, mod);

        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            long value = pair.value;
            int index = pair.index;
            if (rem > 0) {
                value *= second;
                rem--;
            } else {
                value *= first;
            }
            value %= mod;
            nums[index] = (int) value;
        }

        return nums;
    }

    private long powerSum(long a, long b, int mod) {
        long result = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }
}
