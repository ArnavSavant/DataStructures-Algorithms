import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_1091 {
    class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int dist;

        Triplet(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        public int compareTo(Triplet p) {
            if (this.dist == p.dist) {
                return Integer.compare(this.row, p.row);
            }
            return Integer.compare(this.dist, p.dist);
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int distance[][] = new int[n][n];
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        minHeap.add(new Triplet(0, 0, 1));
        distance[0][0] = 1;
        while (!minHeap.isEmpty()) {
            Triplet node = minHeap.poll();
            int[] rowOffsets = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int[] colOffsets = { -1, 0, 1, -1, 1, -1, 0, 1 };
            for (int i = 0; i < 8; i++) {
                int newRow = node.row + rowOffsets[i];
                int newCol = node.col + colOffsets[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    if (grid[newRow][newCol] == 0 && node.dist + 1 < distance[newRow][newCol]) {
                        distance[newRow][newCol] = node.dist + 1;
                        minHeap.add(new Triplet(newRow, newCol, node.dist + 1));
                    }
                }
            }
        }
        return distance[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : distance[n - 1][n - 1];
    }
}
/*
### Documentation for the `shortestPathBinaryMatrix` Method

#### Overview

The `shortestPathBinaryMatrix` method calculates the shortest path from the top-left corner (0,0) to the bottom-right corner (n-1,n-1) in a binary matrix, where a path can only be constructed from cells with a value of 0, and movement is allowed in all 8 directions. The path length is defined as the number of steps from the start to the end, including both endpoints. If no such path exists, the method returns -1.

#### Algorithm

1. **Initial Checks**: Return -1 if the start or end cell is blocked (value = 1), as a path is immediately impossible.
   
2. **Distance Matrix Initialization**: Create a distance matrix of the same dimensions as the grid and initialize all cells to `Integer.MAX_VALUE`, signifying that they are not yet reached. Set the distance to the start cell (0,0) to 1.

3. **Priority Queue**: Initialize a `PriorityQueue` with a custom `Triplet` class that holds row, col, and dist (distance from the start). The queue is sorted first by distance, then by row if distances are equal. Add the start cell with a distance of 1 to the queue.

4. **BFS with Priority Queue**:
   - While the queue is not empty, poll the cell with the smallest distance.
   - For each of the 8 possible moves from the current cell, calculate the new cell's coordinates.
   - If the new cell is within bounds, not blocked, and can be reached in a shorter distance than previously recorded, update its distance and add it to the queue.

5. **Return Path Length**: If the distance to the bottom-right corner is not `Integer.MAX_VALUE`, return it as the shortest path length; otherwise, return -1 to indicate no path exists.

#### Why It Works

This method leverages Dijkstra's algorithm, adapted for a grid by using a priority queue to always process the cell with the current shortest distance next. By exploring all 8 directions from each cell and updating distances to reflect the shortest path found so far, the algorithm guarantees that the shortest path, if it exists, will be found. 

#### Time Complexity

- **O(n^2 log n)**: The algorithm iterates through each cell potentially multiple times (due to updates from various directions), and each insertion and polling operation from the priority queue takes O(log n) time. The actual time complexity can vary based on the grid's structure and the number of updates performed but, in the worst case with a dense grid, it approaches O(n^2 log n).

#### Space Complexity

- **O(n^2)**: Space is used for the distance matrix and the priority queue. In the worst case, the queue might hold a significant fraction of the grid's cells, and the distance matrix is always of size n^2.

#### Summary

The `shortestPathBinaryMatrix` method efficiently finds the shortest path through a binary matrix using a variation of Dijkstra's algorithm. By dynamically updating distances and prioritizing cells based on their current shortest path, the method ensures an optimal solution when a path exists.
 */