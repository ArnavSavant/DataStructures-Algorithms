public class Leetcode_1020 {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && !visited[0][i]) {
                dfs(grid, visited, 0, i);
            }
            if (grid[m - 1][i] == 1 && !visited[m - 1][i]) {
                dfs(grid, visited, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(grid, visited, i, 0);
            }
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                dfs(grid, visited, i, n - 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int grid[][], boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int m = grid.length;
        int n = grid[0].length;
        if (row + 1 < m && grid[row + 1][col] == 1 && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            dfs(grid, visited, row + 1, col);
        }
        if (col + 1 < n && grid[row][col + 1] == 1 && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            dfs(grid, visited, row, col + 1);
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1 && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            dfs(grid, visited, row - 1, col);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1 && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            dfs(grid, visited, row, col - 1);
        }
    }
}
/*
### Documentation for the `numEnclaves` Method

#### Logic of the Code

The `numEnclaves` method calculates the number of enclaves in a given grid. An enclave consists of cells with a value of 1 that cannot reach the grid's boundary. The method employs Depth-First Search (DFS) to mark cells that can reach the boundary, thus identifying cells that are part of an enclave.

Here's how it works:
1. **Initialization**: A `visited` matrix is created to track cells that have been visited during the DFS.
2. **DFS from Boundaries**: The method performs DFS starting from cells with a value of 1 located at the grid's boundaries (top, bottom, left, right edges). This step marks all cells reachable from the boundaries, effectively identifying cells that are not part of an enclave.
3. **Counting Enclaves**: After marking, the method iterates through the entire grid to count cells with a value of 1 that have not been visited, as these represent enclave cells.

#### Intuition to Develop This Logic/Approach

The approach is based on the observation that cells part of an enclave cannot reach the grid's boundary. By marking cells that can reach the boundary (starting the search from boundary cells with a value of 1), we can then easily identify enclave cells as those that remain unvisited. This inverse strategy simplifies the problem by focusing on what can be reached from the edges rather than attempting to directly identify enclaves from within the grid.

#### Why This Code Works

This code is effective because:
- **DFS from Boundaries**: By starting the DFS from the boundary cells, it accurately marks all cells that are connected to the boundary, ensuring that any cell not visited is guaranteed to be part of an enclave.
- **Comprehensive Coverage**: The method checks all four edges of the grid, ensuring no potential path to the boundary is missed.
- **Efficient Marking**: The use of a `visited` matrix prevents revisiting cells, optimizing the search process.

#### Time and Space Complexities

- **Time Complexity**: The time complexity is O(m*n), where m is the number of rows and n is the number of columns in the grid. In the worst case, the DFS might visit each cell once.
  
- **Space Complexity**: The space complexity is also O(m*n) due to the additional `visited` matrix used to track visited cells. The call stack of the recursive DFS also contributes to the space complexity, but this is bounded by the grid's size.

The `numEnclaves` method provides a clear and efficient solution to identify enclave cells in a grid, utilizing a DFS strategy that marks reachable cells from the grid's boundary to isolate those that constitute enclaves.
 */