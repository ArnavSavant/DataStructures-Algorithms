import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
   public ArrayList<String> findPath(int m[][], int n) {
      ArrayList<String> ans = new ArrayList<String>();
      if (m[0][0] == 0) {
         return ans;
      }
      m[0][0] = 0;
      solve(0, 0, m, n, ans, "");
      return ans;
   }

   public void solve(int row, int col, int[][] m, int n, List<String> ans, String s) {
      // System.out.println(s);
      if (row == n - 1 && col == n - 1) {
         if (s.length() != 0) {
            ans.add(new String(s));
         }
         return;
      }
      if (col < n - 1 && m[row][col + 1] == 1) {
         m[row][col + 1] = 0;
         solve(row, col + 1, m, n, ans, s + "R");
         m[row][col + 1] = 1;
      }
      if (row < n - 1 && m[row + 1][col] == 1) {
         m[row + 1][col] = 0;
         solve(row + 1, col, m, n, ans, s + "D");
         m[row + 1][col] = 1;
      }
      if (col > 0 && m[row][col - 1] == 1) {
         m[row][col - 1] = 0;
         solve(row, col - 1, m, n, ans, s + "L");
         m[row][col - 1] = 1;
      }
      if (row > 0 && m[row - 1][col] == 1) {
         m[row - 1][col] = 0;
         solve(row - 1, col, m, n, ans, s + "U");
         m[row - 1][col] = 1;
      }
   }

   public static void main(String[] args) {
      RatInAMaze obj = new RatInAMaze();
      int m[][] = { { 0, 1, 1, 1 },
            { 1, 1, 1, 0 },
            { 1, 0, 1, 1 },
            { 0, 0, 1, 1 } };
      // int m[][] = {{1,0},{1,0}};
      System.out.println(obj.findPath(m, 4));
   }
}
