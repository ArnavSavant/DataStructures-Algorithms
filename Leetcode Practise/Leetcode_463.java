public class Leetcode_463 {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (i == 0) ? 1 : (grid[i - 1][j] == 0 ? 1 : 0);
                    perimeter += (i == rows - 1) ? 1 : (grid[i + 1][j] == 0 ? 1 : 0);
                    perimeter += (j == 0) ? 1 : (grid[i][j - 1] == 0 ? 1 : 0);
                    perimeter += (j == cols - 1) ? 1 : (grid[i][j + 1] == 0 ? 1 : 0);
                }
            }
        }
        return perimeter;
    }
}
