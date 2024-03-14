import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_994 {
    class Triplet {
        int row;
        int col;
        int time;

        Triplet(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean rotten[][] = new boolean[m][n];
        Queue<Triplet> queue = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Triplet(i, j, 0));
                    rotten[i][j] = true;
                } else {
                    rotten[i][j] = false;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        int minTime = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Triplet t = queue.poll();
            minTime = Math.max(t.time, minTime);

            if (t.row + 1 < m && grid[t.row + 1][t.col] == 1 && !rotten[t.row + 1][t.col]) {
                rotten[t.row + 1][t.col] = true;
                queue.add(new Triplet(t.row + 1, t.col, t.time + 1));
                count++;
            }
            if (t.col + 1 < n && grid[t.row][t.col + 1] == 1 && !rotten[t.row][t.col + 1]) {
                rotten[t.row][t.col + 1] = true;
                queue.add(new Triplet(t.row, t.col + 1, t.time + 1));
                count++;
            }
            if (t.row - 1 >= 0 && grid[t.row - 1][t.col] == 1 && !rotten[t.row - 1][t.col]) {
                rotten[t.row - 1][t.col] = true;
                queue.add(new Triplet(t.row - 1, t.col, t.time + 1));
                count++;
            }
            if (t.col - 1 >= 0 && grid[t.row][t.col - 1] == 1 && !rotten[t.row][t.col - 1]) {
                rotten[t.row][t.col - 1] = true;
                queue.add(new Triplet(t.row, t.col - 1, t.time + 1));
                count++;
            }
        }
        if (count != countFresh) {
            return -1;
        }
        return minTime;
    }
}
/*
### Documentation for the `orangesRotting` Method

#### Logic of the Code

The `orangesRotting` method calculates the minimum amount of time required to rot all fresh oranges in a given grid. In this grid, `0` represents an empty cell, `1` represents a fresh orange, and `2` represents a rotten orange. The method utilizes a Breadth-First Search (BFS) approach to propagate the rotting process across adjacent fresh oranges and tracks the progression of time.

Here's a step-by-step breakdown of its logic:
1. **Initialization**: It initializes a `rotten` boolean matrix to track which oranges have become rotten and a queue of `Triplet` objects (representing the row, column, and time at which an orange becomes rotten).
2. **Populating Initial State**: The method iterates through the grid to identify all initially rotten oranges, adding them to the queue with a time of `0`. It also counts the total number of fresh oranges.
3. **BFS to Spread Rot**: The method then processes each rotten orange in the queue, spreading the rot to adjacent fresh oranges. For each rotten orange, it checks its four adjacent cells (up, down, left, right) and if it finds a fresh orange (`grid[i][j] == 1` and not already `rotten`), it marks the orange as rotten, updates the `rotten` matrix, and enqueues a new `Triplet` with incremented time.
4. **Time Calculation**: Throughout the process, it keeps track of the maximum time encountered in a `Triplet` as `minTime`, which represents the minimum time taken for all reachable fresh oranges to rot.
5. **Final Check and Result**: After processing all rotten oranges, it compares the count of oranges made rotten through BFS with the initial count of fresh oranges. If any fresh oranges remain (i.e., the count doesn't match), it returns `-1` to indicate not all oranges can rot. Otherwise, it returns `minTime`.

#### Intuition to Develop This Logic/Approach

The intuition behind using BFS for this problem stems from the nature of the rotting process—it spreads uniformly and simultaneously from all rotten oranges to their adjacent fresh oranges. BFS perfectly models this spreading process, allowing the algorithm to track the progression of time as the rot spreads across the grid.

#### Why This Code Works

This code works effectively for the problem due to its ability to:
- **Accurately Model the Rotting Process**: By using BFS, the method mirrors the real-world spread of rot from one orange to adjacent ones, considering the uniform time progression.
- **Efficiently Track Time and Rot Spread**: Through the use of a `Triplet` class to store each orange's location and the time at which it rots, the method efficiently keeps track of the minimum time required to rot all fresh oranges.
- **Ensure Correctness with Final Check**: By comparing the count of oranges that have rotted during the process with the initial count of fresh oranges, the method ensures the correctness of its result.

#### Time and Space Complexities

- **Time Complexity**: The time complexity is O(m*n), where m is the number of rows and n is the number of columns in the grid. This accounts for the worst-case scenario where the method has to visit and check each cell in the grid.
  
- **Space Complexity**: The space complexity is O(m*n) due to the additional `rotten` matrix used to track the state of each cell and the queue that, in the worst case, could hold all oranges in the grid.

The `orangesRotting` method provides a clear and efficient solution for determining the minimum time required to rot all fresh oranges in a grid, leveraging BFS to model the rotting process's spread accurately.
 */