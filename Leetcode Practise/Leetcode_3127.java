public class Leetcode_3127 {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int black = 0;
                int white = 0;
                int dRow[] = { 0, 0, 1, 1 };
                int dCol[] = { 0, 1, 0, 1 };
                for (int k = 0; k < 4; k++) {
                    if (grid[i + dRow[k]][j + dCol[k]] == 'B') {
                        black++;
                    } else {
                        white++;
                    }
                }
                if (black == 1 || white == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
