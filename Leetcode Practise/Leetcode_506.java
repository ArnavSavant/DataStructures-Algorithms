import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_506 {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            mp.put(score[i], i);
        }
        Arrays.sort(score);
        String answer[] = new String[score.length];
        int rank = 1;
        for (int i = score.length - 1; i >= 0; i--) {
            if (rank == 1) {
                answer[mp.get(score[i])] = "Gold Medal";
            } else if (rank == 2) {
                answer[mp.get(score[i])] = "Silver Medal";
            } else if (rank == 3) {
                answer[mp.get(score[i])] = "Bronze Medal";
            } else {
                answer[mp.get(score[i])] = rank + "";
            }
            rank++;
        }
        return answer;
    }
}
