public class PrintLongestCommonSubsequence1 {

   // recurssive code
   // public String printLongestCommonSubsequence(String a, String b, int m, int n)
   // {
   // if(n==0 || m==0) {
   // return "";
   // }
   // if(a.charAt(m-1) == b.charAt(n-1)) {
   // return printLongestCommonSubsequence(a, b, m-1, n-1)+a.charAt(m-1);
   // }
   // else {
   // if(printLongestCommonSubsequence(a, b, m-1,
   // n).length()>printLongestCommonSubsequence(a, b, m, n-1).length()) {
   // return printLongestCommonSubsequence(a, b, m-1, n);
   // }
   // else {
   // return printLongestCommonSubsequence(a, b, m, n-1);
   // }
   // }
   // }

   // DP approach
   public int[][] longestCommonSubsequence(String a, String b, int m, int n) {
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
      return t;
   }

   public String printLongestCommonSubsequence(String a, String b, int m, int n) {
      int t[][] = longestCommonSubsequence(a, b, m, n);
      int i = m;
      int j = n;
      String s = "";
      while (i > 0 && j > 0) {
         if (a.charAt(i - 1) == b.charAt(j - 1)) {
            s = a.charAt(i - 1) + s;
            i--;
            j--;
         } else {
            if (t[i - 1][j] > t[i][j - 1]) {
               i--;
            } else {
               j--;
            }
         }
      }
      return s;
   }

   public static void main(String[] args) {
      PrintLongestCommonSubsequence1 obj = new PrintLongestCommonSubsequence1();
      String a = "abedhg";
      String b = "abcdrgh";
      System.out.println(obj.printLongestCommonSubsequence(a, b, a.length(), b.length()));
   }
}
