import java.util.*;

public class Leetcode_857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];

        // Create an array of workers with their quality, wage, and ratio of
        // wage/quality
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i], (double) wage[i] / quality[i]);
        }

        // Sort workers by their ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));

        double minCost = Double.MAX_VALUE;
        int sumQuality = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through workers and calculate minimum cost
        for (Worker worker : workers) {
            // Add current worker's quality to the max-heap and sumQuality
            maxHeap.add(worker.quality);
            sumQuality += worker.quality;

            // If max-heap size exceeds k, remove the highest quality to maintain the size
            if (maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }

            // If we have exactly k workers, calculate the cost of this group
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, sumQuality * worker.ratio);
            }
        }

        return minCost;
    }

    static class Worker {
        int quality;
        int wage;
        double ratio;

        public Worker(int quality, int wage, double ratio) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = ratio;
        }
    }
}
