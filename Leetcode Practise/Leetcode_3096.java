public class Leetcode_3096 {
    public int minimumLevels(int[] possible) {
        int totalScore = 0;
        for (int level : possible) {
            if (level == 0) {
                totalScore = totalScore - 1;
            } else {
                totalScore = totalScore + 1;
            }
        }
        int currScore = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            if (possible[i] == 0) {
                currScore = currScore - 1;
            } else {
                currScore = currScore + 1;
            }
            if (currScore > (totalScore - currScore)) {
                return i + 1;
            }
        }
        return -1;
    }
}
