import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode_3273 {

    public class Pair implements Comparable<Pair> {
        double priority;
        int index;

        Pair(double p, int i) {
            this.priority = p;
            this.index = i;
        }

        public int compareTo(Pair p) {
            if (this.priority == p.priority) {
                return Integer.compare(this.index, p.index);
            }
            return Double.compare(this.priority, p.priority);
        }
    }

    public long minDamage(int power, int[] damage, int[] health) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < health.length; i++) {
            int timeTakenToKill = (int) Math.ceil(health[i] * 1.0 / power);
            maxHeap.add(new Pair(damage[i] * 1.0 / timeTakenToKill, i));
        }
        long totalTime = 0;
        long totalDamage = 0;
        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            totalTime += (int) Math.ceil(health[p.index] * 1.0 / power);
            totalDamage += damage[p.index] * totalTime;
        }
        return totalDamage;
    }
}
