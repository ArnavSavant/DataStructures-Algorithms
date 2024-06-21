import java.util.Arrays;

public class Leetcode_1552 {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int high = position[n - 1] - position[0];
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            low = Math.min(low, position[i + 1] - position[i]);
        }
        int maxDistance = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (isPossible(position, m, n, mid)) {
                maxDistance = Math.max(maxDistance, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxDistance;
    }

    public boolean isPossible(int[] position, int m, int n, int min) {
        int currPos = position[0];
        for (int i = 1; i < n; i++) {
            if ((position[i] - currPos) >= min) {
                currPos = position[i];
                m--;
            }
            if (m == 0) {
                return true;
            }
        }
        return false;
    }
}