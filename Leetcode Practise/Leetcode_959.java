public class Leetcode_959 {
    public int regionsBySlashes(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int newRow = 3 * row;
        int newCol = 3 * col;
        int newGrid[][] = new int[newRow][newCol];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int startRow = i * 3;
                int startCol = j * 3;
                if (grid[i].charAt(j) == '/') {
                    newGrid[startRow][startCol + 2] = 1;
                    newGrid[startRow + 1][startCol + 1] = 1;
                    newGrid[startRow + 2][startCol] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    newGrid[startRow][startCol] = 1;
                    newGrid[startRow + 1][startCol + 1] = 1;
                    newGrid[startRow + 2][startCol + 2] = 1;
                }
            }
        }
        boolean[][] visited = new boolean[newRow][newCol];
        int res = 0;
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                if (newGrid[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, newRow, newCol, newGrid, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int row, int col, int m, int n, int[][] newGrid, boolean[][] visited) {
        visited[row][col] = true;
        int dRow[] = { 0, 1, 0, -1 };
        int dCol[] = { 1, 0, -1, 0 };
        for (int k = 0; k < 4; k++) {
            int newRow = row + dRow[k];
            int newCol = col + dCol[k];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            } else if (newGrid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                dfs(newRow, newCol, m, n, newGrid, visited);
            }
        }
    }
}
