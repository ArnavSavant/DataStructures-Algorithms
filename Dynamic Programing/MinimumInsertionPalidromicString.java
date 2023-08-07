public class MinimumInsertionPalidromicString {
   
   // recursive approach
   // public int longestPalidromicSubsequence(String x, int m, int n) {
   //    if (n == 0) {
   //       return 0;
   //    }
   //    if (m == n - 1) {
   //       return 1;
   //    }
   //    if (x.charAt(m) == x.charAt(n - 1) && m + 2 == n) {
   //       return 2;
   //    }
   //    if (x.charAt(m) == x.charAt(n - 1)) {
   //       return 2 + longestPalidromicSubsequence(x, m + 1, n - 1);
   //    } else {
   //       return Math.max(longestPalidromicSubsequence(x, m + 1, n),
   //             longestPalidromicSubsequence(x, m, n - 1));
   //    }
   // }

   public int mimimunInsertionString(String x) {
      return x.length() - longestPalidromicSubsequence(x);
   }

   public int longestPalidromicSubsequence(String a) {
      return LCS(a, reverseString(a), a.length(), a.length());
   }

   public String reverseString(String x) {
      String y = "";
      for (int i = x.length() - 1; i >= 0; i--) {
         y = y + x.charAt(i);
      }
      return y;
   }

   public int LCS(String a, String b, int m, int n) {
      int t[][] = new int[m + 1][n + 1];
      for (int i = 0; i <= m; i++) {
         t[i][0] = 0;
      }
      for (int i = 0; i <= n; i++) {
         t[0][i] = 0;
      }
      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
               t[i][j] = 1 + t[i - 1][j - 1];
            } else {
               t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
         }
      }
      return t[m][n];
   }

   public static void main(String[] args) {
      MinimumInsertionPalidromicString obj = new MinimumInsertionPalidromicString();
      String x = "abecbda";
      // System.out.println(obj.longestPalidromicSubsequence(x, 0, x.length()));
      System.out.println(obj.mimimunInsertionString(x));
   }
}
