import java.util.PriorityQueue;

public class Leetcode_1631 {
    class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int diff;

        Triplet(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }

        public int compareTo(Triplet p) {
            if (this.diff == p.diff) {
                return Integer.compare(this.row, p.row);
            }
            return Integer.compare(this.diff, p.diff);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int distance[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0; 
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
        minHeap.add(new Triplet(0, 0, 0));
        while (!minHeap.isEmpty()) {
            Triplet node = minHeap.poll();
            if (node.row == row - 1 && node.col == col - 1) {
                return node.diff;
            }
            int[] rowOffsets = { -1, 0, 1, 0 };
            int[] colOffsets = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int newRow = node.row + rowOffsets[i];
                int newCol = node.col + colOffsets[i];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                    int newDiff = Math.max(Math.abs(heights[newRow][newCol] - heights[node.row][node.col]), node.diff);
                    if (newDiff < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newDiff;
                        minHeap.add(new Triplet(newRow, newCol, newDiff));
                    }
                }
            }
        }
        return 0;
    }
}
