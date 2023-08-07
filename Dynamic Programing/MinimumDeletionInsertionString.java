public class MinimumDeletionInsertionString {
   public void minimumDeletionInsertion(String a, String b, int m, int n) {
      int lcs = LCS(a, b, m, n);
      System.out.println("Deletion " + (m - lcs));
      System.out.println("Insertion " + (n - lcs));
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
      MinimumDeletionInsertionString obj = new MinimumDeletionInsertionString();
      String a="heap";
      String b="pea";
      obj.minimumDeletionInsertion(a, b, a.length(), b.length());
   }
}
