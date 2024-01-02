import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    static int minCost(int arr[], int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int x : arr) {
            minHeap.add(x);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int x1 = minHeap.poll();
            int x2 = minHeap.poll();
            cost = x1 + x2;
            minHeap.add(cost);
        }
        return cost;
    }
}