import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_452 {
    public int findMinArrowShots(int[][] points) {
        int noOfArrows = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        int currStart = points[0][0];
        int currEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (currEnd >= points[i][0]) {
                currStart = Math.max(currStart, points[i][0]);
                currEnd = Math.min(currEnd, points[i][1]);
            } else {
                noOfArrows++;
                currStart = points[i][0];
                currEnd = points[i][1];
            }
        }
        noOfArrows++;
        return noOfArrows;
    }
}