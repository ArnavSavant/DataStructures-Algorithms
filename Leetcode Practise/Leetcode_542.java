import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_542 {
    class Triplet {
        int row;
        int col;
        int dist;

        Triplet(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<Triplet> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Triplet(i, j, 0));
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        while (!queue.isEmpty()) {
            Triplet t = queue.poll();
            ans[t.row][t.col] = t.dist;
            if (t.row + 1 < m && !visited[t.row + 1][t.col]) {
                queue.add(new Triplet(t.row + 1, t.col, t.dist + 1));
                visited[t.row + 1][t.col] = true;
            }
            if (t.col + 1 < n && !visited[t.row][t.col + 1]) {
                queue.add(new Triplet(t.row, t.col + 1, t.dist + 1));
                visited[t.row][t.col + 1] = true;
            }
            if (t.row - 1 >= 0 && !visited[t.row - 1][t.col]) {
                queue.add(new Triplet(t.row - 1, t.col, t.dist + 1));
                visited[t.row - 1][t.col] = true;
            }
            if (t.col - 1 >= 0 && !visited[t.row][t.col - 1]) {
                queue.add(new Triplet(t.row, t.col - 1, t.dist + 1));
                visited[t.row][t.col - 1] = true;
            }
        }
        return ans;
    }
}
/*
### Documentation for the `updateMatrix` Method

#### Overview

The `updateMatrix` method is designed to transform a given matrix such that each cell contains the distance to the nearest 0. The input matrix `mat` consists of cells with either 0 or 1, and the distance between two cells is defined as the absolute difference in their positions (Manhattan distance). This method utilizes a Breadth-First Search (BFS) approach to efficiently calculate these distances.

#### Algorithm

1. **Initialization**: 
   - A result matrix `ans` of the same dimensions as `mat` is initialized to store the distances.
   - A boolean matrix `visited` is initialized to track which cells have been processed.
   - A queue of `Triplet` objects (representing row, column, and the current distance) is used to perform the BFS.

2. **Identify Zeros**: 
   - Iterate through the matrix `mat`, and for each cell that contains 0, add a corresponding `Triplet` to the queue with distance 0 and mark it as visited.

3. **BFS Traversal**: 
   - While the queue is not empty, repeatedly dequeue a `Triplet` and:
     - Update the `ans` matrix with the distance.
     - For each of the four possible directions (up, down, left, right) from the current cell:
       - If the next cell is within bounds, not visited, and is a 1, enqueue a new `Triplet` with incremented distance and mark it as visited.

#### Why It Works

This method works due to its systematic expansion from every 0 in the matrix. By starting the BFS from these zeros and exploring outward, it ensures that each cell's distance to the nearest 0 is calculated based on the shortest path (in terms of the number of steps) to reach a 0. The BFS approach guarantees that the cells are visited in the order of their distance from the nearest 0, ensuring optimal distance values are computed.

#### Time and Space Complexity

- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns in the matrix. Each cell is inserted into and removed from the queue exactly once.

- **Space Complexity**: O(m * n) for the worst case, considering the queue might, at some point, contain a large fraction of the cells and the space needed for the `visited` matrix and the `ans` matrix. However, the practical space usage might be less depending on the distribution of 0s and 1s in the input matrix.

#### Summary

The `updateMatrix` method efficiently calculates the minimum distance to the nearest 0 for all cells in a given matrix using BFS. This approach is both intuitive and effective, leveraging the BFS traversal pattern to ensure that each cell's distance is calculated accurately and efficiently.
 */