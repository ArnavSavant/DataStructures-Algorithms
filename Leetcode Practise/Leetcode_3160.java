import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode_3160 {
    public int[] queryResults(int limit, int[][] queries) {
        int ans[] = new int[queries.length];
        Map<Integer, Integer> ballMap = new HashMap<Integer, Integer>();
        Map<Integer, HashSet<Integer>> colorMap = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                int oldColor = ballMap.get(ball);
                HashSet<Integer> setOfBall = colorMap.get(oldColor);
                setOfBall.remove(ball);
                colorMap.put(oldColor, setOfBall);
                if (setOfBall.size() == 0) {
                    colorMap.remove(oldColor);
                }
            }
            ballMap.put(ball, color);
            if (!colorMap.containsKey(color)) {
                colorMap.put(color, new HashSet<>());
            }
            HashSet<Integer> setOfBall = colorMap.get(color);
            setOfBall.add(ball);
            colorMap.put(color, setOfBall);
            ans[i] = colorMap.size();
        }
        return ans;
    }
}
