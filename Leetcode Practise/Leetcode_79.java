public class Leetcode_79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(k)) {
                    boolean flag = solve(board, word, i, j, k + 1, m, n);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, String word, int row, int col, int k, int m, int n) {
        if (k == word.length()) {
            return true;
        }
        char y = board[row][col];
        board[row][col] = '.';
        int rowDummy[] = { 0, 1, 0, -1 };
        int colDummy[] = { 1, 0, -1, 0 };
        for (int x = 0; x < 4; x++) {
            int newRow = row + rowDummy[x];
            int newCol = col + colDummy[x];
            if ((newRow >= 0 && newRow < m) && (newCol >= 0 && newCol < n)) {
                if (board[newRow][newCol] == word.charAt(k)) {
                    boolean flag = solve(board, word, newRow, newCol, k + 1, m, n);
                    if (flag) {
                        return flag;
                    }
                }
            }
        }
        board[row][col] = y;
        return false;
    }
}
/*
 * Alright, let's break down this code step by step.
 * 
 * ### Problem Statement:
 * The code aims to determine if a given word can be constructed from the
 * letters of sequentially adjacent cell, where "adjacent" cells are
 * horizontally or vertically neighboring cells. The same cell may not be used
 * more than once.
 * 
 * ### Logic & Intuition:
 * The problem can be visualized as a search on a grid, trying to find a path
 * that forms the given word. This naturally brings to mind a Depth First Search
 * (DFS) approach, which is exactly what the two-pointer technique in this code
 * is implementing.
 * 
 * ### Explanation of the code:
 * 1. **Main Function (`exist`)**:
 * Loops through every cell in the board.
 * If the character in the current cell matches the first character of the word,
 * it initiates a recursive DFS search (`solve` function) from that cell.
 * If at any point the DFS search returns true, the `exist` function immediately
 * returns true, indicating that the word can be formed from the board.
 * 
 * 2. **DFS Search Function (`solve`)**:
 * This is a recursive function that tries to match the word with characters
 * from the board starting from a given cell `(row, col)`.
 * Base Case: If the intermediate word `s` matches the given word, it returns
 * true.
 * The current cell's character is temporarily changed to a marker ('.') to
 * avoid revisiting it in the current path.
 * Four possible searches are initiated from the current cell - up, down, left,
 * and right, provided they are within the boundary and the next character
 * matches the next character in the word.
 * After the DFS from the current cell is done, the character is reverted back
 * to its original value.
 * If any of the four possible directions return true, `solve` returns true.
 * Else, it backtracks and returns false.
 * 
 * ### Why this code works:
 * **Depth-First Search**: The code uses a recursive DFS which is a powerful
 * method for exploring all possible paths in a grid-like structure.
 * **Backtracking**: The modification and restoration of the board at `(row,
 * col)` is a backtracking step that ensures previously visited cells in the
 * current path aren't revisited, but can still be used for other paths.
 * **Exhaustive Search**: By iterating over each cell in the board and
 * attempting to match the word, the solution ensures that all possible paths
 * are considered.
 * 
 * ### Optimizations:
 * The given code can be further optimized:
 * 1. Instead of using a string `s` to keep the current word and then compare it
 * with the target word, just use an index (like `k`) to check if we've formed
 * the word (as it's done). This would save the string concatenation operations
 * and the string comparison.
 * 2. Directly pass the next character's index (`k`) to be matched rather than
 * forming the intermediate word.
 * 
 * Overall, the approach is optimal for this kind of problem, and the
 * two-pointer technique ensures an efficient exploration of the grid.
 */
