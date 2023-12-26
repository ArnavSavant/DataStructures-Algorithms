import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public int findKthSmallest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() > (k)) {
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}