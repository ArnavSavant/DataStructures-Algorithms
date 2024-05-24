public class NumberOfIslands1 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, m, n, visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int row, int col, int m, int n, boolean[][] visited) {
        visited[row][col] = true;
        int dRow[] = { 1, 0, -1, 0 };
        int dCol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            } else if (grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, m, n, visited);
            }
        }
    }
}
