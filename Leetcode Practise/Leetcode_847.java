import java.util.HashSet;
import java.util.Set;

public class Leetcode_847 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int obstacle[] : obstacles) {
            set.add(obstacle[0] + "-" + obstacle[1]);
        }
        int directions[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int ind = 0;
        int X = 0;
        int Y = 0;
        int maxDistance = 0;
        for (int command : commands) {
            if (command == -2) {
                if (ind == 0) {
                    ind = 3;
                } else {
                    ind--;
                }
            } else if (command == -1) {
                if (ind == 3) {
                    ind = 0;
                } else {
                    ind++;
                }
            } else {
                for (int i = 1; i <= command; i++) {
                    int currX = X + directions[ind][0];
                    int currY = Y + directions[ind][1];
                    if (set.contains(currX + "-" + currY)) {
                        break;
                    }
                    X = currX;
                    Y = currY;
                    maxDistance = Math.max(maxDistance, currX * currX + currY * currY);
                }
            }
        }
        return maxDistance;
    }
}
