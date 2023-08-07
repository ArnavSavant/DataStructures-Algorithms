public class LongestCommonSubsequence {

   // recursive code
   // public int LCS(String x, String y, int n, int m) {
   // if (n == 0 || m == 0) {
   // return 0;
   // }
   // if (x.charAt(n - 1) == y.charAt(m - 1)) {
   // return 1 + LCS(x, y, n - 1, m - 1);
   // } else {
   // return Math.max(LCS(x, y, n - 1, m), LCS(x, y, n, m - 1));
   // }
   // }

   public void printTable(int arr[][], int m, int n) {
      for(int i=0;i<=m;i++) {
         for (int j = 0; j <=n; j++) {
            System.out.print(arr[i][j]+" ");
         }
         System.out.println("");
      }
   }

   // Top-Down DP approach
   public int LCS(String x, String y, int m, int n) {
      int t[][] = new int[m + 1][n + 1];
      for (int i = 0; i <= m; i++) {
         t[i][0] = 0;
      }
      for (int i = 0; i <= n; i++) {
         t[0][i] = 0;
      }
      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
               t[i][j] = 1 + t[i - 1][j - 1];
            } else {
               t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
         }
      }
      printTable(t, m, n);
      return t[m][n];
   }

   public static void main(String[] args) {
      LongestCommonSubsequence obj = new LongestCommonSubsequence();
      String x = "abedh";
      String y = "abcdrhg";
      System.out.println(obj.LCS(x, y, x.length(), y.length()));
   }
}
