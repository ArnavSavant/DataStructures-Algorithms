public class Leetcode_37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char x = '1'; x <= '9'; x++) {
                        if (possible(board, i, j, x)) {
                            board[i][j] = x;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean possible(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c || board[k][j] == c || board[3 * (i / 3) + k / 3][3 * (j / 3) + (k % 3)] == c) {
                return false;
            }
        }
        return true;
    }
}
/*
Let's begin by understanding the problem that this code aims to solve. The code provides a solution to the classic Sudoku puzzle. In a standard Sudoku puzzle, you have a 9x9 grid, where the objective is to fill the board with digits in such a way that each row, each column, and each of the nine 3x3 subgrids (also called "boxes") contain all of the digits from 1 to 9.

The code provides a method named `solveSudoku` that initiates the solving process by calling the recursive `solve` method.

Here's a step-by-step explanation:

### 1. The solveSudoku Method:
This is a simple public interface method to start the solution process. It calls the main recursive solving method named `solve`.

### 2. The Recursive solve Method:

**Logic & Intuition:**

- It loops through the entire board, row by row, searching for an empty spot (indicated by the character '.'). 
- When an empty spot is found (at `board[i][j]`), it tries to place digits from '1' to '9' in that spot.
- For each digit, it checks if placing that digit in the current spot is valid. This check is done by the `possible` method.
- If placing the digit is valid, it updates the board with that digit and then recurses to try to solve the rest of the board.
- If, during further recursion, it finds that the board can't be solved with the current configuration, it backtracks (reverts `board[i][j]` back to '.') and tries the next digit.
- If no digits can be placed in the current empty spot that leads to a solution, the method returns false, causing more backtracking.
- If the entire board is iterated without finding any empty spots, it means the board is filled and the method returns true, indicating a solution has been found.

### 3. The possible Method:

**Logic & Intuition:**

- For a given empty spot `board[i][j]` and a character `c` representing a digit, it checks:
  - All the cells in the same row `i` to see if the digit `c` already exists.
  - All the cells in the same column `j` to see if the digit `c` already exists.
  - All the cells in the 3x3 box containing `board[i][j]` to see if the digit `c` already exists.
  
  The logic `board[3 * (i / 3) + k / 3][3 * (j / 3) + (k % 3)]` can be a bit tricky, but it's used to traverse the 3x3 box. Here's how it works:
  - `i/3` and `j/3` determine which of the 3x3 boxes we're in.
  - `3 * (i / 3)` and `3 * (j / 3)` give the starting row and column of the box.
  - `k/3` and `k%3` provide the offset within the box.
  
- If `c` is found in any of the mentioned locations, the method returns false. Otherwise, it returns true, indicating that `c` can be placed in the spot `board[i][j]`.

### Why does this code work?

This solution works because it employs a classic backtracking approach. Backtracking is a systematic way to iterate through all the possible configurations of a problem to find a solution. For Sudoku, it means trying out different numbers in each cell until a valid board configuration is found.

By using recursion, the code can dive deep into a series of decisions. If at any point it realizes a decision (i.e., placing a number) doesn't lead to a solution, it can backtrack to a previous decision and make a different choice. 

When the `solve` method eventually completes the board without finding any more empty spots, it knows that a solution has been reached. If it runs into an impasse (i.e., no numbers can be placed in a current empty cell), it backtracks to try different numbers in previous cells.
 */
