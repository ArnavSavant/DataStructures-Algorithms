//LPS is nothing but LCS of the string and it's reverse.
public class PrintingLongestPalidromicString {
   // recursive code
   // public String printingLongestPalidromicString(String a, int m, int n) {
   // if(n==0) {
   // return "";
   // }
   // if(m==n-1) {
   // return ""+a.charAt(m);
   // }
   // if(a.charAt(m)==a.charAt(n-1) && m+2==n) {
   // return ""+a.charAt(m)+a.charAt(n-1);
   // }
   // if(a.charAt(m)==a.charAt(n-1)) {
   // return ""+a.charAt(m)+printingLongestPalidromicString(a, m+1,
   // n-1)+a.charAt(n-1);
   // }
   // else {
   // if(printingLongestPalidromicString(a, m+1,
   // n).length()>printingLongestPalidromicString(a, m, n-1).length()) {
   // return printingLongestPalidromicString(a, m+1, n);
   // }
   // else {
   // return printingLongestPalidromicString(a, m, n-1);
   // }
   // }
   // }

   // TOP DOWN DP approach
   public int[][] longestPalidromicString(String a, String b, int m, int n) {
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

   public String reverseString(String x) {
      String y = "";
      for (int i = x.length() - 1; i >= 0; i--) {
         y = y + x.charAt(i);
      }
      return y;
   }


   // public void printTable(int arr[][], int m, int n) {
   //    for(int i=0;i<=m;i++) {
   //       for (int j = 0; j <=n; j++) {
   //          System.out.print(arr[i][j]+" ");
   //       }
   //       System.out.println("");
   //    }
   // }

   public String printingLongestPalidromicString(String x, String y, int m, int n) {
      int t[][] = longestPalidromicString(x, y, x.length(), y.length());
      int i = m;
      int j = n;
      String s = "";
      while(i>0 && j>0) {
         if(x.charAt(i-1) == y.charAt(j-1) ) {
            s=x.charAt(i-1)+s;
            i--;
            j--;
         }
         else {
            if(t[i-1][j]>t[i][j-1]) {
               i--;
            }
            else {
               j--;
            }
         }
      }
      return s;
   }
   
   public static void main(String[] args) {
      PrintingLongestPalidromicString obj = new PrintingLongestPalidromicString();
      String a = "abgdcdbea";
      // System.out.println(obj.printingLongestPalidromicString(a, 0, a.length()));
      // obj.printTable(obj.longestPalidromicString(a, obj.reverseString(a),a.length(),a.length()), a.length(), a.length());
      System.out.println(obj.printingLongestPalidromicString(a, obj.reverseString(a), a.length(), a.length()));

   }
}
