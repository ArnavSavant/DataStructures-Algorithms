import java.util.Arrays;

public class Leetcode_3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int currStart = points[0][0];
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] - currStart > w) {
                count++;
                currStart = points[i][0];
            }
        }
        return count + 1;
    }
}
