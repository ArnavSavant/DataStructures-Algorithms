public class Leetcode_3142 {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] != grid[i + 1][j] || grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        for (int j = 0; j < n - 1; j++) {
            if (grid[m - 1][j] == grid[m - 1][j + 1]) {
                return false;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            if (grid[i][n - 1] != grid[i + 1][n - 1]) {
                return false;
            }
        }
        return true;
    }
}
