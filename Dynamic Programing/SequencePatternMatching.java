public class SequencePatternMatching {
   public String longestCommonSubsequence(String x, String y, int m, int n) {
      if(n==0 || m==0) {
         return "";
      }
      if(x.charAt(m-1)==y.charAt(n-1)) {
         return longestCommonSubsequence(x, y, m-1, n-1)+x.charAt(m-1);
      }
      else {
         if(longestCommonSubsequence(x, y, m-1, n).length()>longestCommonSubsequence(x, y, m, n-1).length()) {
            return longestCommonSubsequence(x, y, m-1, n);
         }
         else {
            return longestCommonSubsequence(x, y, m, n-1);
         }
      }
   }
   public boolean sequencePatternMatching(String x, String y) {
      String lcs = longestCommonSubsequence(x, y, x.length(), y.length());
      if(x.equals(lcs) || y.equals(lcs)) {
         return true;
      }
      else {
         return false;
      }
   }
   public static void main(String[] args) {
      SequencePatternMatching obj = new SequencePatternMatching();
      String x="AXY";
      String y= "ADXCPY";
      System.out.println(obj.longestCommonSubsequence(x, y, x.length(), y.length()));
      System.out.println(obj.sequencePatternMatching(x, y));
   }
}
