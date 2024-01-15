import java.util.PriorityQueue;

public class ShortestJobFirst {
    public static class Pair implements Comparable<Pair> {
        int arrivalTime;
        int burstTime;

        Pair(int at, int bt) {
            this.arrivalTime = at;
            this.burstTime = bt;
        }

        public int compareTo(Pair o) {
            if (this.burstTime == o.burstTime) {
                return Integer.compare(this.arrivalTime, o.arrivalTime);
            }
            return Integer.compare(this.burstTime, o.burstTime);
        }
    }

    public static float sjf(int n, int[] arrivalTime, int[] burstTime) {
        PriorityQueue<Pair> process = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            process.add(new Pair(arrivalTime[i], burstTime[i]));
        }

        return 0.0f;
    }
}
