public class LongestRepeatingSubsequence {
   // recursive code
   // public int longestRepeatingSubsequence(String x, String y, int m, int n) {
   //    if(m==0 || n==0) {
   //       return 0;
   //    }
   //    if(x.charAt(m-1)==y.charAt(n-1) && m!=n) { //index should be different
   //       return 1+longestRepeatingSubsequence(x, y, m-1, n-1);
   //    }
   //    return Math.max(longestRepeatingSubsequence(x, y, m-1, n), longestRepeatingSubsequence(x, y, m, n-1));
   // }

   //DP approach
   public int longestRepeatingSubsequence(String x, String y,int m, int n) {
      int t[][]=new int[m+1][n+1];
      for(int i=0;i<=m;i++) {
         t[0][i]=0;
      }
      for(int i=0;i<=n;i++) {
         t[i][0]=0;
      }
      for(int i=1;i<=m;i++) {
         for(int j=1;j<=n;j++) {
            if(x.charAt(i-1)==y.charAt(j-1) && i!=j) {
               t[i][j]=1+t[i-1][j-1];
            }
            else {
               t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
         }
      }
      return t[m][n];
   } 
   public static void main(String[] args) {
      LongestRepeatingSubsequence obj = new LongestRepeatingSubsequence();
      String a="aacdbdb";
      System.out.println(obj.longestRepeatingSubsequence(a, a, a.length(), a.length()));
   }
}
