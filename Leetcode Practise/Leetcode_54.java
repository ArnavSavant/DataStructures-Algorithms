import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
   public List<Integer> spiralOrder(int[][] matrix) {
      int x = 0;
      int y = 0;
      int n = matrix.length;
      int m = matrix[0].length;
      List<Integer> res = new ArrayList<Integer>();
      while (x < m && y < n) {

         for (int i = x; i < m; i++) {
            res.add(matrix[y][i]);
         }
         y++;

         for (int i = y; i < n; i++) {
            res.add(matrix[i][m-1]);
         }
         m--;

         if(y<n) {
            for (int i = m; i >= x; i--) {
               res.add(matrix[n-1][i]);
            }
            n--;
         }

         if(x<m) {
            for (int i = n; i >= y; i--) {
               res.add(matrix[i][x]);
            }
            x++;
         }
      }
      return res;
   }
}

/*
 1. Initialization:
x and y are initialized to 0, representing the starting coordinates.
n and m are the dimensions of the matrix, with n being the number of rows and m the number of columns.
res is an ArrayList that will store the result of the spiral traversal.
2. Spiral Traversal:
The code uses a while loop to iterate through the matrix in a spiral pattern. The loop continues until x < m and y < n, ensuring that the traversal stays within the bounds of the matrix.

a. Traverse Right:
The first for loop traverses from the current x to m-1, adding elements from the current row (y) to res.
Increment y to move to the next row.
b. Traverse Down:
The second for loop traverses from the current y to n-1, adding elements from the last column (m-1) to res.
Decrement m to exclude the last column from further traversal.
c. Traverse Left:
If y < n, the third for loop traverses from m-1 to x, adding elements from the last row (n-1) to res.
Decrement n to exclude the last row from further traversal.
d. Traverse Up:
If x < m, the fourth for loop traverses from n-1 to y, adding elements from the first column (x) to res.
Increment x to exclude the first column from further traversal.
3. Result:
The res list now contains the elements of the matrix in a spiral order.
Intuition:
The code simulates the pattern of moving right, down, left, and up in a matrix, gradually shrinking the bounds as it progresses.
By adjusting the variables x, y, m, and n, the code ensures that each element is visited exactly once.
In essence, this code captures the natural way one might trace a spiral pattern on paper, but it does so programmatically for a 2D matrix.
 */
