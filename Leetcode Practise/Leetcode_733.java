import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_733 {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int orignal = image[sr][sc];
        if (orignal == color) {
            return image;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            image[p.row][p.col] = color;

            if (p.row + 1 < m && image[p.row + 1][p.col] == orignal) {
                queue.add(new Pair(p.row + 1, p.col));
            }
            if (p.col + 1 < n && image[p.row][p.col + 1] == orignal) {
                queue.add(new Pair(p.row, p.col + 1));
            }
            if (p.row - 1 >= 0 && image[p.row - 1][p.col] == orignal) {
                queue.add(new Pair(p.row - 1, p.col));
            }
            if (p.col - 1 >= 0 && image[p.row][p.col - 1] == orignal) {
                queue.add(new Pair(p.row, p.col - 1));
            }
        }
        return image;
    }
}
/*
The provided `floodFill` method implements a flood fill algorithm to color a contiguous area of pixels in a 2D image. Given a starting pixel (sr, sc) and a new color, it changes the color of the starting pixel and all adjacent pixels of the same original color to the new color.

### Algorithm

1. **Initialization**: 
   - Determine the dimensions of the image (`m` x `n`).
   - Store the original color of the starting pixel (`orignal`).
   - If the original color is the same as the new color, return the image immediately to avoid unnecessary processing.

2. **BFS Queue**: 
   - Initialize a queue to perform breadth-first search (BFS), starting with the given pixel coordinates (`sr`, `sc`).

3. **Flood Fill Process**:
   - While the queue is not empty, remove the front pair (`p`), representing the current pixel coordinates.
   - Change the color of the current pixel to the new color.
   - Check all four adjacent pixels (up, down, left, right). If any have the same original color, add their coordinates to the queue for processing.

4. **Return Updated Image**: Once the queue is empty, all connected pixels of the original color have been changed to the new color, and the updated image is returned.

### Why It Works

The method works because it uses BFS to systematically explore all pixels connected to the starting pixel that have the same original color. By enqueuing adjacent pixels of the original color and processing each pixel until no such adjacent pixels remain, the algorithm ensures that the entire contiguous area is filled with the new color.

### Time and Space Complexity

- **Time Complexity**: O(m * n), where `m` and `n` are the dimensions of the image. In the worst case, every pixel in the image might need to be visited once.

- **Space Complexity**: O(m * n) in the worst case, due to the queue potentially holding a number of elements proportional to the total number of pixels in the image when a large contiguous area needs to be filled.

### Summary

The `floodFill` method effectively implements a flood fill algorithm using BFS, allowing for the efficient coloring of a contiguous region in a 2D image. This approach guarantees that all pixels of the target area are filled with the new color, leveraging the queue to manage the BFS process systematically.
 */