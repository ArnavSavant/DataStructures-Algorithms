public class PalidromePartitioning {
   int t[][]= new int[1001][1001]; //dimmension of the array depends upon the number of variables that are changing in the func call.
   public void initialize() {
      for(int i=0;i<1001;i++) {
         for(int j=0;j<1001;j++) {
            t[i][j]=-1;
         }
      }
   }
   public int solve(String s, int i, int j) {
      if(t[i][j]!=-1) {
         return t[i][j];
      }
      if(i>=j) {
         return 0;
      }
      if(isPalindrome(s,i,j)==true) {
         return 0;
      }
      int minPart=Integer.MAX_VALUE;
      for(int k=i;k<=j-1;k++) {
         int temp1=0;
         int temp2=0;
         if(t[i][k]!=-1) {
           temp1= t[i][k];
         }
         else {
            temp1=solve(s, i, k);
         }
         if(t[k+1][j]!=-1) {
            temp2= t[k+1][j];
          }
          else {
             temp2=solve(s, k+1, j);
          }
         int temp=1+temp1+temp2;
         minPart=Math.min(minPart, temp);
      }
      t[i][j]=minPart;
      return minPart;
   }
   public boolean isPalindrome(String s, int i, int j) {
      String str=s.substring(i, j+1);
      if(str.equals(reverseString(str))) {
         return true;
      }
      else {
         return false;
      }
   }
   public String reverseString(String x) {
      String y = "";
      for (int i = x.length() - 1; i >= 0; i--) {
         y = y + x.charAt(i);
      }
      return y;
   }
   public static void main(String[] args) {
      PalidromePartitioning obj = new PalidromePartitioning();
      String s="nitil";
      obj.initialize();
      System.out.println(obj.solve(s, 0, s.length()-1));
   }
}
