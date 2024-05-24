public class Leetcode_200 {
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
/*
The provided `numIslands` function effectively counts the number of islands in a given 2D grid, where an 'island' is represented by '1's that are connected horizontally or vertically. The function utilizes Depth-First Search (DFS) to explore and mark each part of an island, thereby ensuring each individual island is only counted once.

### Overview of the Algorithm

1. **Initialization**:
   - Variables `m` and `n` represent the dimensions of the grid.
   - An `ans` counter is initialized to zero to keep track of the number of islands.
   - A 2D boolean array `visited` is initialized to track whether a cell in the grid has been visited.

2. **Iterate Over the Grid**:
   - The outer loops iterate over each cell of the grid.
   - When an unvisited '1' is found, it indicates the start of a new island.

3. **Depth-First Search (DFS) Implementation**:
   - The `dfs` method is called with the coordinates of the unvisited '1'.
   - The method sets the cell as visited.
   - It then explores all four possible directions (up, down, left, right) recursively.
   - For each direction, the method checks if the move is within bounds and whether the destination cell contains '1' and is unvisited. If both conditions are satisfied, `dfs` is called recursively for that cell.

4. **Count and Return the Number of Islands**:
   - Each call to `dfs` from the main function corresponds to discovering a new island, so `ans` is incremented each time.
   - After all cells are processed, `ans` holds the total number of islands, which is then returned.

### Corrections and Improvements

The current implementation is correct and should work effectively for typical use cases. However, here are a few minor improvements and considerations:

- **Error Handling**: Adding checks for edge cases, such as an empty grid, can enhance robustness.
- **Code Optimization**: The `else if` in the DFS can be simplified to just `if` since the `continue` statement in the previous line ensures the conditions are mutually exclusive.
- **Iterative DFS**: To avoid potential stack overflow for very large grids or very large islands, consider implementing an iterative version of DFS using a stack.

### Example

For example, given a grid:

```
[
  ["1", "1", "0", "0", "0"],
  ["1", "1", "0", "0", "0"],
  ["0", "0", "1", "0", "0"],
  ["0", "0", "0", "1", "1"]
]
```

The function will count three islands.

### Time and Space Complexity

- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns in the grid. Each cell is visited at most once.
- **Space Complexity**: O(m * n) in the worst case due to the recursive stack space in the case of a grid filled with '1's making a large recursive call stack, or due to the `visited` array storage.

This solution is optimal for typical constraints and effectively utilizes DFS for solving the connected components (islands) counting problem in a grid.
 */