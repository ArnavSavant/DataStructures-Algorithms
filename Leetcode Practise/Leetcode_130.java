public class Leetcode_130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(board, 0, i, visited);
            }
            if (board[m - 1][i] == 'O' && !visited[m - 1][i]) {
                dfs(board, m - 1, i, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, visited);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(board, i, n - 1, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char board[][], int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int m = board.length;
        int n = board[0].length;
        if (row + 1 < m && !visited[row + 1][col] && board[row + 1][col] == 'O') {
            dfs(board, row + 1, col, visited);
        }
        if (col + 1 < n && !visited[row][col + 1] && board[row][col + 1] == 'O') {
            dfs(board, row, col + 1, visited);
        }
        if (row - 1 >= 0 && !visited[row - 1][col] && board[row - 1][col] == 'O') {
            dfs(board, row - 1, col, visited);
        }
        if (col - 1 >= 0 && !visited[row][col - 1] && board[row][col - 1] == 'O') {
            dfs(board, row, col - 1, visited);
        }
    }
}
/*
### Documentation for the `solve` Method

#### Logic of the Code

The `solve` method is designed to solve the problem of capturing surrounded regions on a 2D board. Each cell on the board can be either 'X' or 'O'. A group of 'O's is captured and flipped to 'X's if it is surrounded by 'X's on all sides. The method ensures that 'O's on the border and any 'O's connected to them directly or indirectly are not flipped. It employs Depth-First Search (DFS) to mark 'O's that cannot be captured:

1. **Initialization**: A boolean 2D array `visited` of the same dimensions as the board is created to keep track of visited cells during the DFS.

2. **Border DFS**: The method starts DFS from all 'O's on the borders (top, bottom, left, right). Since these 'O's and any 'O's connected to them cannot be captured (as they are not surrounded by 'X's on all sides), the DFS marks them as visited.

3. **Capture Surrounded Regions**: After marking all uncapturable 'O's, the method iterates over the entire board. Any 'O' that is not visited (thus not connected to any border 'O') is surrounded by 'X's and is flipped to 'X'.

4. **DFS Implementation**: The `dfs` method recursively visits all 'O's connected to the given cell (row, col). It marks the current cell as visited and explores its four adjacent cells (up, down, left, right), continuing the process for each unvisited 'O'.

#### Intuition to Develop This Logic/Approach

The intuition behind using DFS from the borders is that any 'O' connected to the border cannot be fully surrounded by 'X's, directly implying that it and its connected 'O's are not capturable. Starting the search from the borders simplifies the problem by immediately identifying and marking the uncapturable 'O's, thus allowing for a straightforward identification of capturable regions in the subsequent step.

#### Why This Code Works

This code effectively solves the problem due to its methodical approach to identifying capturable and uncapturable regions. By employing DFS from the borders to mark uncapturable 'O's:
- It guarantees that all 'O's connected to the border are accurately identified and preserved.
- It ensures that any 'O's not reachable from the borders are capturable, allowing for a simple pass to flip these to 'X's.
- The use of a visited array prevents revisiting cells, optimizing the DFS process.

#### Time and Space Complexities

- **Time Complexity**: The time complexity is O(m*n), where m is the number of rows and n is the number of columns in the board. In the worst case, the DFS might need to visit every cell on the board once.

- **Space Complexity**: The space complexity is also O(m*n) due to the use of the `visited` array to keep track of visited cells. The recursive DFS calls also contribute to the space complexity, particularly in cases where the recursion stack grows deep; however, this is bounded by the size of the board.

The `solve` method efficiently identifies and captures surrounded regions on a board, leveraging DFS to mark uncapturable 'O's starting from the borders and subsequently flipping capturable 'O's, thereby solving the problem with a clear and effective strategy.
 */