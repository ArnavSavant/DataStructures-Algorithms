public class LongestCommonSubstring2 {
   public int longestCommonSubstring(String x, String y, int m, int n) {
      int t[][] = new int[m + 1][n + 1];
      for (int i = 0; i <= m; i++) {
         t[i][0] = 0;
      }
      for (int i = 0; i <= n; i++) {
         t[0][i] = 0;
      }
      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= m; j++) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
               t[i][j] = 1 + t[i - 1][j - 1];
            } else {
               t[i][j] = 0;
            }
         }
      }
      return t[m][n];
   }

   //recursive code
   // public int longestCommonSubstring(String x, String y, int m, int n, int res) {
   //    if(n==0 || m==0) {
   //       return res;
   //    }

   //    if(x.charAt(m-1) == y.charAt(n-1)) {
   //       return longestCommonSubstring(x, y, m-1, n-1, res+1);
   //    }
   //    res = Math.max(res, Math.max(longestCommonSubstring(x, y, m-1, n, 0), longestCommonSubstring(x, y, m, n-1, 0)));
   //    return res;
   // }
   public static void main(String[] args) {
      LongestCommonSubstring2 obj = new LongestCommonSubstring2();
      String x = "abexymc";
      String y = "abdxyml";
      // System.out.println(obj.longestCommonSubstring(x, y, x.length(), y.length(),0));
      System.out.println(obj.longestCommonSubstring(x, y, x.length(), y.length()));
   }
}