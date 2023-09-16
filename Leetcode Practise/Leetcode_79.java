public class Leetcode_79 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String s = "";
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = solve(board, word, s + board[i][j], i, j, 1, n, m);
                    if (flag == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, String word, String s, int row, int col, int k, int n, int m) {
        if (s.length() == word.length() || k == word.length()) {
            if (s.compareTo(word) == 0) {
                return true;
            }
            return false;
        }
        char x = board[row][col];
        board[row][col] = '.';
        boolean flag1 = false;
        if (row < n - 1 && word.charAt(k) == board[row + 1][col]) {
            flag1 = solve(board, word, s + board[row + 1][col], row + 1, col, k + 1, n, m);

        }
        boolean flag2 = false;
        if (col < m - 1 && word.charAt(k) == board[row][col + 1]) {
            flag2 = solve(board, word, s + board[row][col + 1], row, col + 1, k + 1, n, m);

        }
        boolean flag3 = false;
        if (row > 0 && word.charAt(k) == board[row - 1][col]) {
            flag3 = solve(board, word, s + board[row - 1][col], row - 1, col, k + 1, n, m);

        }
        boolean flag4 = false;
        if (col > 0 && word.charAt(k) == board[row][col - 1]) {
            flag4 = solve(board, word, s + board[row][col - 1], row, col - 1, k + 1, n, m);
        }
        board[row][col] = x;
        return (flag1 || flag2 || flag3 || flag4);
    }
}
/*
Alright, let's break down this code step by step.

### Problem Statement:
The code aims to determine if a given word can be constructed from the letters of sequentially adjacent cell, where "adjacent" cells are horizontally or vertically neighboring cells. The same cell may not be used more than once.

### Logic & Intuition:
The problem can be visualized as a search on a grid, trying to find a path that forms the given word. This naturally brings to mind a Depth First Search (DFS) approach, which is exactly what the two-pointer technique in this code is implementing.

### Explanation of the code:
1. **Main Function (`exist`)**:
    * Loops through every cell in the board.
    * If the character in the current cell matches the first character of the word, it initiates a recursive DFS search (`solve` function) from that cell.
    * If at any point the DFS search returns true, the `exist` function immediately returns true, indicating that the word can be formed from the board.

2. **DFS Search Function (`solve`)**:
    * This is a recursive function that tries to match the word with characters from the board starting from a given cell `(row, col)`.
    * Base Case: If the intermediate word `s` matches the given word, it returns true.
    * The current cell's character is temporarily changed to a marker ('.') to avoid revisiting it in the current path.
    * Four possible searches are initiated from the current cell - up, down, left, and right, provided they are within the boundary and the next character matches the next character in the word.
    * After the DFS from the current cell is done, the character is reverted back to its original value.
    * If any of the four possible directions return true, `solve` returns true. Else, it backtracks and returns false.

### Why this code works:
* **Depth-First Search**: The code uses a recursive DFS which is a powerful method for exploring all possible paths in a grid-like structure.
* **Backtracking**: The modification and restoration of the board at `(row, col)` is a backtracking step that ensures previously visited cells in the current path aren't revisited, but can still be used for other paths.
* **Exhaustive Search**: By iterating over each cell in the board and attempting to match the word, the solution ensures that all possible paths are considered.

### Optimizations:
The given code can be further optimized:
1. Instead of using a string `s` to keep the current word and then compare it with the target word, just use an index (like `k`) to check if we've formed the word (as it's done). This would save the string concatenation operations and the string comparison.
2. Directly pass the next character's index (`k`) to be matched rather than forming the intermediate word.

Overall, the approach is optimal for this kind of problem, and the two-pointer technique ensures an efficient exploration of the grid.
 */
