public class PrintShortestCommonSupersequence {
   
   //recursive code
   // public String printShortestCommonSupersequence(String a, String b, int m, int n) {
   //    // if(m==0 && n==0) {
   //    //    return "";
   //    // }
   //    if(m>0 && n>0) {
   //       if(a.charAt(m-1)==b.charAt(n-1)) {
   //          return printShortestCommonSupersequence(a, b, m-1, n-1) + a.charAt(m-1);
   //       }
   //       else {
   //          if(printShortestCommonSupersequence(a, b, m-1, n).length() < printShortestCommonSupersequence(a, b, m, n-1).length()) {
   //             return printShortestCommonSupersequence(a, b, m-1, n) + a.charAt(m-1);
   //          }
   //          else {
   //             return printShortestCommonSupersequence(a, b, m, n-1) + b.charAt(n-1);
   //          }
   //       }
   //    }
   //    if(m>0) {
   //       return printShortestCommonSupersequence(a, b, m-1, n) + a.charAt(m-1);
   //    }
   //    if(n>0) {
   //       return printShortestCommonSupersequence(a, b, m, n-1) + b.charAt(n-1);
   //    }
   //    return "";
   // }
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

   public String printShortestCommonSupersequence(String a, String b, int m, int n) {
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
               s = a.charAt(i - 1) + s;
               i--;
            } else {
               s = a.charAt(j - 1) + s;
               j--;
            }
         }
      }
      while (i > 0) {
         s = a.charAt(i - 1) + s;
         i--;
      }
      while (j > 0) {
         s = b.charAt(j - 1) + s;
         j--;
      }
      return s;
   }

   public static void main(String[] args) {
      PrintShortestCommonSupersequence obj = new PrintShortestCommonSupersequence();
      String a = "geek";
      String b = "eke";
      System.out.println(obj.printShortestCommonSupersequence(a, b, a.length(), b.length()));
   }
}
