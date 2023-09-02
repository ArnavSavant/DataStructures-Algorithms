class ListNode {
   int val;
   ListNode next;

   ListNode() {
   }

   ListNode(int val) {
      this.val = val;
   }

   ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
   }
}

public class SpiralMatrixIV {
   public int[][] spiralMatrix(int m, int n, ListNode head) {
      int i, x = 0, y = 0;
      int t[][] = new int[m][n];
      while (head != null) {
         for (i = y; i < n && head != null; i++) {
            t[x][i] = head.val;
            head = head.next;
         }
         x++;

         for (i = x; i < m && head != null; i++) { // top to bottom
            t[i][n - 1] = head.val;
            head = head.next;
         }
         n--;

         if (x < m) {
            for (i = n - 1; i >= y && head != null; i--) { // right to left
               t[m - 1][i] = head.val;
               head = head.next;
            }
            m--;
         }

         if (y < n) {
            for (i = m - 1; i >= x && head != null; i--) { // bottom to top
               t[i][y] = head.val;
               head = head.next;
            }
         }
         y++;
      }

      while (x < m && y < n) {
         for (i = y; i < n; i++) { // Left to right
            t[x][i] = -1;
         }
         x++;

         for (i = x; i < m; i++) { // top to bottom
            t[i][n - 1] = -1;
         }
         n--;

         if (x < m) {
            for (i = n - 1; i >= y; i--) { // right to left
               t[m - 1][i] = -1;
            }
            m--;
         }

         if (y < n) {
            for (i = m - 1; i >= x; i--) { // bottom to top
               t[i][y] = -1;
            }
            y++;
         }
      }
      return t;
   }
}