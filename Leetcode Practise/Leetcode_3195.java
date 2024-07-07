public class Leetcode_3195 {
    public int minimumArea(int[][] grid) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int x = Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    a = Math.min(a, i);
                    b = Math.max(b, i);
                    x = Math.min(x, j);
                    y = Math.max(y, j);
                }
            }
        }
        return (b - a + 1) * (y - x + 1);
    }
}
